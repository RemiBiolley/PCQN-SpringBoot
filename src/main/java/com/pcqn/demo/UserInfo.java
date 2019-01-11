package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserInfo implements Serializable {
    @OneToOne
    private User user;

    @ManyToOne
    private Game game;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Prenom", nullable = true)
    private String firstName;

    @Column(name="Nom", nullable = true)
    private String lastName;

    @Column(name="Telephone", nullable = true)
    private String telephone;

    public UserInfo() {
    }

    public UserInfo(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
