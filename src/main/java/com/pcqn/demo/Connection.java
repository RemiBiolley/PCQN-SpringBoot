package com.pcqn.demo;

import java.io.Serializable;
import java.util.Objects;

public class Connection implements Serializable {

    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean connectVerif(String password, String email){
        if(Objects.equals(this.password, password) && Objects.equals(this.email, email)){
            return true;
        }
        else{
            return false;
        }
    }

}
