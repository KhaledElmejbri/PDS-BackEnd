package org.sesame.ms.security.authentication.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotBlank
    @Size(max = 15)
    private String lastName;

    private String sex;


    private String profilePicture;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    private String portfolioId;

    private String job;

    private SesameClasse sesameClasse;

    private String profBackground;

    @Transient
    private List<SesameClasse> assignedClasses = new ArrayList<SesameClasse>();


    @Size(max = 10)
    private String lancode;

    @Size(max = 10)
    private String userrole;

    private Boolean locked;
    private String phone;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(String portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public SesameClasse getSesameClasse() {
        return sesameClasse;
    }

    public void setSesameClasse(SesameClasse sesameClasse) {
        this.sesameClasse = sesameClasse;
    }

    public String getProfBackground() {
        return profBackground;
    }

    public void setProfBackground(String profBackground) {
        this.profBackground = profBackground;
    }

    public List<SesameClasse> getAssignedClasses() {
        return assignedClasses;
    }

    public void setAssignedClasses(List<SesameClasse> assignedClasses) {
        this.assignedClasses = assignedClasses;
    }


    public String getLancode() {
        return lancode;
    }

    public void setLancode(String lancode) {
        this.lancode = lancode;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

