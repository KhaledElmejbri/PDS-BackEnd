package org.sesame.ms.security.authentication.models;

public class UserSummary {

    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String lancode;
    private String userrole;
    private Boolean locked;
    private String phone;
    private boolean changepassword;
    private String usertype;



    public UserSummary(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;

    }

    public UserSummary(Long id, String username, String name, String surname,
                       String email,
                       String lancode, String userrole,
                       Boolean locked, String phone,
                       boolean changepassword) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;

        this.surname = surname;

        this.userrole = userrole;
        this.lancode = lancode;

        this.locked = locked;
        this.phone = phone;
        this.changepassword = changepassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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



    public Boolean isLocked() {
        return locked;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean isChangepassword() {
        return changepassword;
    }

    public void setChangepassword(boolean changepassword) {
        this.changepassword = changepassword;
    }



    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }




}
