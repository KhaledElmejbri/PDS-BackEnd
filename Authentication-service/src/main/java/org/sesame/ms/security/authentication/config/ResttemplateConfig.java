package org.sesame.ms.security.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

//@Configuration
public class ResttemplateConfig {



//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(customerApiUsername, customerApiPassword));
//        return restTemplate;
//    }

    /* in case of using jwt
    *
    *   private final RestTemplate restTemplate;

    private String jwtToken;

    public JwtAuthenticationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String authenticate(String username, String password) {
        String authenticationUrl = "https://api.customer.com/authenticate";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, password);
        ResponseEntity<String> response = restTemplate.exchange(authenticationUrl, HttpMethod.POST, new HttpEntity<>(headers), String.class);
        jwtToken = response.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        return jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    // Method to refresh JWT token if needed
}
    *
    *
    *
    *  */
}

