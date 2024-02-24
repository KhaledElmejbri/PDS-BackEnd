package org.sesame.ms.security.authentication.models;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    @ApiModelProperty(notes = "User Identifacation code")
    private String email;

    @ApiModelProperty(notes = "User Identifacation Password")
    private String password;

    @ApiModelProperty(notes = "User Identifacation PasswordHached")
    private String passwordHached;

    public JwtRequest(String username) {
        super();
        this.email = username;
    }

    //need default constructor for JSON Parsing
    public JwtRequest() {
    }

    public JwtRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHached() {
        return passwordHached;
    }

    public void setPasswordHached(String passwordHached) {
        this.passwordHached = passwordHached;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
