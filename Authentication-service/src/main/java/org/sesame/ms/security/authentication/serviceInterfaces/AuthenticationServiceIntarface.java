package org.sesame.ms.security.authentication.serviceInterfaces;


import org.sesame.ms.security.authentication.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthenticationServiceIntarface {

    ResponseEntity<ResultModel> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception;

    //Get UserCredential, using to authorize access of other microservices
    ResponseEntity<ResultModel> getGTCurrentUser(@CurrentUser UserCredentiel currentUser,
                                                 @RequestHeader(name = "Authorization") String token);

    ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception;


    UserSummary getCurrentUser(@CurrentUser UserCredentiel currentUser);


}
