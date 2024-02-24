package org.sesame.ms.security.authentication.controllers;


import io.swagger.annotations.ApiOperation;
import org.sesame.ms.security.authentication.models.*;
import org.sesame.ms.security.authentication.serviceInterfaces.AuthenticationServiceIntarface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {


    @Autowired
    private AuthenticationServiceIntarface authenticationServiceIntarface;

    @ApiOperation("Generate Authentication Token")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

       return authenticationServiceIntarface.createAuthenticationToken(authenticationRequest);

    }

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/authenticatess")
    public ResponseEntity<String> getSuppliers() {
        String apiUrl = "https://apigateway.nsiabanque.com/api/soap/getCustomerList?wsdl";
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        return response;
    }


    @RequestMapping(value = "/authenticateme", method = RequestMethod.POST)
    public ResponseEntity<ResultModel> getGTCurrentUser(@CurrentUser UserCredentiel currentUser,
                                                        @RequestHeader(name = "Authorization") String token) {

        return authenticationServiceIntarface.getGTCurrentUser(currentUser, token);
    }


    @ApiOperation("Method to register new users")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
       return  authenticationServiceIntarface.saveUser(user);
    }




    @ApiOperation("Return authenticated user")
    @GetMapping("/authenticate/me")
    public UserSummary getCurrentUser(@CurrentUser UserCredentiel currentUser) {

        return authenticationServiceIntarface.getCurrentUser(currentUser);

    }


}
