package org.sesame.ms.security.authentication.config;


import io.jsonwebtoken.*;
import org.sesame.ms.security.authentication.models.UserCredentiel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Component
public class JwtTokenProvider {

    //private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {

        UserCredentiel userPrincipal = (UserCredentiel) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getRegistrationID()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }


    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            // logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            // logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            //  logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            //  logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            //  logger.error("JWT claims string is empty.");
        }
        return false;
    }
}