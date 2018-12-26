package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserInfo implements Serializable {
    @OneToOne
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Prenom", nullable = true)
    private String firstName;

    @Column(name="Nom", nullable = true)
    private String lastName;

    @Column(name="Telephone", nullable = true)
    private String telephone;

    @Column(name="Jeu_Prefere", nullable = true)
    private String favGame;

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

    public String getFavGame() {
        return favGame;
    }

    public void setFavGame(String favGame) {
        this.favGame = favGame;
    }
}
