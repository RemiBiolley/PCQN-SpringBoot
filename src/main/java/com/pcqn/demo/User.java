package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User implements Serializable{
    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;

    @ManyToOne
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private Collection<Note> notes;

    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="Pseudo", nullable = false)
    private String userName;

    @Column(name="Email", nullable = false)
    private String email;

    @Column(name="Mdp", nullable = false)
    private String password;

    @Column(name="Avatar", nullable = true)
    private String avatar;

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Collection<Note> getNotes() {
        return notes;
    }

    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRandomAvatar(){
        ArrayList<String> defaultAvatars = new ArrayList<String>();
        defaultAvatars.add("https://mir-s3-cdn-cf.behance.net/project_modules/disp/636b6721340091.562ff8a1e6d56.jpg");
        defaultAvatars.add("https://mir-s3-cdn-cf.behance.net/project_modules/disp/1e60c921340091.562ff8a203d4a.jpg");
        defaultAvatars.add("https://mir-s3-cdn-cf.behance.net/project_modules/disp/3eb13e21340091.562ff8a21c1f8.jpg");
        defaultAvatars.add("https://mir-s3-cdn-cf.behance.net/project_modules/disp/3a11a921340091.562ff8a218e81.jpg");

        int random = (int)(Math.random() * 3 + 0);

        this.avatar = defaultAvatars.get(random);
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
