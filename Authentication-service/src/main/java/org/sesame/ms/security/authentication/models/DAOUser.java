package org.sesame.ms.security.authentication.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class DAOUser{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationID;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "classid", nullable = true)
    @Transient
    private SesameClasse sesameClasse;

    private String profBackground;


    @JsonIgnore
    @OneToMany(
            mappedBy = "users",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    ) private List<SesameClasse> assignedClasses = new ArrayList<SesameClasse>();


    @Size(max = 10)
    private String lancode;

    @Size(max = 10)
    private String userrole;

    private Boolean locked;
    private String phone;

    private int failedattempt;

    public DAOUser() {

    }

    public DAOUser(String firstName, String lastName, String sex, String profilePicture, String email, String portfolioId, String job, SesameClasse sesameClasse, String profBackground, List<SesameClasse> assignedClasses, String userrole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.profilePicture = profilePicture;
        this.email = email;
        this.portfolioId = portfolioId;
        this.job = job;
        this.sesameClasse = sesameClasse;
        this.profBackground = profBackground;
        this.assignedClasses = assignedClasses;
        this.userrole = userrole;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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




    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Long getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Long registrationID) {
        this.registrationID = registrationID;
    }

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

    public void setAssignedClasses(List<SesameClasse> assignedClasses) {
        this.assignedClasses = assignedClasses;
    }

    public List<SesameClasse> getAssignedClasses() {
        return assignedClasses;
    }

    public int getFailedattempt() {
        return failedattempt;
    }

    public void setFailedattempt(int failedattempt) {
        this.failedattempt = failedattempt;
    }


}
