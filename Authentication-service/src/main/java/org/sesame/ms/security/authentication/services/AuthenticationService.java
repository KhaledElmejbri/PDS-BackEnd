package org.sesame.ms.security.authentication.services;


import org.sesame.ms.security.authentication.FailedAuthHandler.LoginFailException;
import org.sesame.ms.security.authentication.config.JwtTokenProvider;
import org.sesame.ms.security.authentication.models.*;
import org.sesame.ms.security.authentication.repositories.LogsRepository;
import org.sesame.ms.security.authentication.serviceInterfaces.AuthenticationServiceIntarface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class AuthenticationService implements AuthenticationServiceIntarface {

    private static final String BEARER = "Bearer ";

    @Autowired
    private JwtTokenProvider provider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private LogsRepository logsRepository;




    @Override
    public ResponseEntity<ResultModel> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws LoginFailException {


        Boolean isLocked = false;
        int attempts = 0;

        try {
            try {


                isLocked = logsRepository.getIsUserLocked(authenticationRequest.getEmail());
                if (isLocked==null) {
                    throw new Exception();
                }
                if (isLocked) {
                    throw new Exception();
                }



                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                authenticationRequest.getEmail(),
                                 authenticationRequest.getPassword()
                        )
                );




                SecurityContextHolder.getContext().setAuthentication(authentication);
                UserCredentiel credential = (UserCredentiel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();



                //always return attempts to 0 when login
                logsRepository.updateFailedAttempts(authenticationRequest.getEmail(), 0);




                //password used in the

                String jwt = provider.generateToken(authentication);

                //   userLogsInterface.saveLogs(credential.getId(), credential.getUserrole());

                return new ResponseEntity<ResultModel>(ResultModel._200("Authenticated with success", credential,jwt), HttpStatus.OK);


            } catch (Exception e) {

                attempts =  logsRepository.getFailedAttempts(authenticationRequest.getEmail());

                throw new LoginFailException(authenticationRequest.getEmail(), logsRepository,isLocked,attempts);


            }
        } catch (Exception e) {

            if (isLocked)
                return new ResponseEntity<ResultModel>(ResultModel.unauthorized("Locked Account", null,null), HttpStatus.UNAUTHORIZED);
            else

                return new ResponseEntity<ResultModel>(ResultModel.unauthorized("Unauthorized you still have ".concat(String.valueOf(3-attempts))+ " attempts ", null, null), HttpStatus.UNAUTHORIZED);

        }
    }

    //Get UserCredential, using to authorize access of other microservices
    @Override
    public ResponseEntity<ResultModel> getGTCurrentUser(@CurrentUser UserCredentiel currentUser,
                                                        @RequestHeader(name = "Authorization") String token) {

        try {

            UserCredentiel user = new UserCredentiel(
                    currentUser.getRegistrationID(),
                    currentUser.getFirstName(),
                    currentUser.getLastName(),
                    currentUser.getEmail(),
                    currentUser.getSex(),
                    currentUser.getPassword(),
                    currentUser.getPortfolioId(),
                    currentUser.getJob(),
                    currentUser.getSesameClasse(),
                    currentUser.getProfBackground(),
                    currentUser.getAssignedClasses(),
                    currentUser.getUserrole());




            if (user != null) {

                return new ResponseEntity<ResultModel>(ResultModel._200("Success", user, token), HttpStatus.OK);

            } else {

                return new ResponseEntity<ResultModel>(ResultModel.unauthorized("Not authorized", user, token), HttpStatus.UNAUTHORIZED);
            }

        } catch (Exception e) {
            return new ResponseEntity<ResultModel>(ResultModel.unauthorized(e.getMessage(), null, token), HttpStatus.UNAUTHORIZED);
        }
    }


    @Override
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(jwtUserDetailsService.save(user));
    }



    @Override
    public UserSummary getCurrentUser(@CurrentUser UserCredentiel currentUser) {

//        return new UserSummary(currentUser.getId(), currentUser.getUsername(),
//                currentUser.getName(), currentUser.getSurname() ,currentUser.getEmail(),currentUser.getLancode(), currentUser.getUserrole(),
//                currentUser.getLocked(), currentUser.getPhone(), currentUser.isChangepassword());

        return null;

    }

}
