package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class UserType implements Serializable {
    @OneToMany(mappedBy = "userType")
    private Collection<User> users;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="Nom_Type", nullable = false)
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
