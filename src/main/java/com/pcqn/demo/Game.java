package com.pcqn.demo;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Game implements Serializable {
    @OneToMany(mappedBy = "game")
    private Collection<Note> notes;

    @OneToMany(mappedBy = "game")
    private Collection<UserInfo> userInfos;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Nom", nullable = false)
    private String name;

    @Column(name="Nombre_Notes", nullable = false)
    private Integer nbreNotes;

    @Column(name="Note_Moyenne", nullable = false)
    @Max(5)
    @Min(0)
    private float note;

    @Column(name="Editeur", nullable = true)
    private String editeur;

    @Column(name="Jeu_Moment", nullable = false)
    @Max(1)
    @Min(0)
    private Integer momentGame;

    @Column(name="Jaquette", nullable= true)
    private String box;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNbreNotes() {
        return nbreNotes;
    }

    public void setNbreNotes(Integer nbreNotes) {
        this.nbreNotes = nbreNotes;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Integer getMomentGame() {
        return momentGame;
    }

    public void setMomentGame(Integer momentGame) {
        this.momentGame = momentGame;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public void increaseNoteCounter(){
        this.setNbreNotes(this.nbreNotes+1);
    }

    public Collection<Note> getNotes() {
        return notes;
    }

    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
    }

    public Collection<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(Collection<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
