package org.sesame.ms.security.authentication.models;

import javax.persistence.*;

@Entity
@Table(name="sesame_class")
public class SesameClasse {

    @Id
    private String classid;

    private String name;

    private int level;

    private String groupname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "registrationID", nullable = false)
    private DAOUser users;


    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getId() {
        return classid;
    }

    public void setId(String classid) {
        this.classid = classid;
    }

    public String getName() {
        return name;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public DAOUser getUsers() {
        return users;
    }

    public void setUsers(DAOUser users) {
        this.users = users;
    }
}
