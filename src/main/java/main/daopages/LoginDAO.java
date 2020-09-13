package main.daopages;

import org.springframework.beans.factory.annotation.Value;

public class LoginDAO {

    private String url;
    private String user;
    private String pass;


    public String getUrl() {
        return url;
    }

    @Value("${login_url}")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    @Value("${login_user}")
    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    @Value("login_pass")
    public void setPass(String pass) {
        this.pass = pass;
    }
}
