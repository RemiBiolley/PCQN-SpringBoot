package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User implements Serializable{
    public User(){
        this.points = 0;
        this.rank = "Bleusaille";
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserInfo userInfo;

    @ManyToOne
    private UserType userType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Note> notes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
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

    @Column(name="points", nullable = false)
    private Integer points;

    @Column(name="rang", nullable = false)
    private String rank;

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

        int random = (int)(Math.random() * 4 + 0);

        this.avatar = defaultAvatars.get(random);
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void checkRank(){
        Integer points = this.points;
        if(points<=5){
            this.setRank("Bleusaille");
        }
        else if(points<=20){
            this.setRank("Apprenti aventurier");
        }
        else if(points<=40){
            this.setRank("Plombier moustachu");
        }
        else if(points<=100){
            this.setRank("MasterChief");
        }
        else{
            this.setRank("Dieu de la guerre");
        }
    }
}
