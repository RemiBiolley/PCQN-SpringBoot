package com.pcqn.demo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Game {
    @OneToMany(mappedBy = "game")
    private Collection<Note> notes;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Nom", nullable = false)
    private String name;

    @Column(name="Nombre_Notes", nullable = false)
    private Integer nbreNotes;

    @Column(name="Editeur", nullable = true)
    private String editeur;

    @Column(name="Jeu_Moment", nullable = false)
    private boolean momentGame;

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
}
