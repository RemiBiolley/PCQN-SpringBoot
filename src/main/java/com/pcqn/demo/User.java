package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class User implements Serializable{
    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    @ManyToOne
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Collection<Note> notes;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="Pseudo", nullable = false)
    private String userName;

    @Column(name="Email", nullable = false)
    private String email;

    @Column(name="Mdp", nullable = false)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
