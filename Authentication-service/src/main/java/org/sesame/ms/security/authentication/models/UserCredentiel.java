package org.sesame.ms.security.authentication.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserCredentiel implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long registrationID;

    private String firstName;

    private String lastName;

    private String email;

    private String sex;

    @JsonIgnore
    private String password;

    private String portfolioId;

    private String job;

    private SesameClasse sesameClasse;

    private String profBackground;

    private List<SesameClasse> assignedClasses = new ArrayList<>();
    private String lancode;
    private String userrole;


    public UserCredentiel(Long registrationID, String firstName, String lastName, String email, String sex,String password, String portfolioId, String job, SesameClasse sesameClasse, String profBackground, List<SesameClasse> assignedClasses, String userrole) {
        this.registrationID = registrationID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.password = password;
        this.portfolioId = portfolioId;
        this.job = job;
        this.sesameClasse = sesameClasse;
        this.profBackground = profBackground;
        this.assignedClasses = assignedClasses;
        this.userrole = userrole;
    }

    public static UserCredentiel create(DAOUser user) {
       
    	
        return new UserCredentiel(
                user.getRegistrationID(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getSex(),
                user.getPassword(),
                user.getPortfolioId(),
                user.getJob(),
                user.getSesameClasse(),
                user.getProfBackground(),
                user.getAssignedClasses(),
                user.getUserrole()
        );
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentiel that = (UserCredentiel) o;
        return Objects.equals(registrationID, that.registrationID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(registrationID);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getEmail() {
        return email;
    }


}
