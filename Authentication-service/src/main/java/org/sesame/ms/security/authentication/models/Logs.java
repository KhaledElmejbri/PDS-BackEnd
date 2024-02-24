package org.sesame.ms.security.authentication.models;


import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="logs")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hostname;
    private String hostadr;
    private Instant connectedat;
    private String uri;
    private String username;
    private Long userid;
    private String userrole;
    private String browser;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getHostadr() {
        return hostadr;
    }

    public void setHostadr(String hostadr) {
        this.hostadr = hostadr;
    }

    public Instant getConnectedat() {
        return connectedat;
    }

    public void setConnectedat(Instant connectedat) {
        this.connectedat = connectedat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
    
    
    
}
