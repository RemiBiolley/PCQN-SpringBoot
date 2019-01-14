package com.pcqn.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Comment implements Serializable {
    @ManyToOne
    @JoinColumn(name="comment_id", referencedColumnName = "id")
    private Comment parentComment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentComment")
    private Collection<Comment> childrenComment;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "contenu", nullable = false)
    private String content;

    @Column(name="date", nullable = false)
    private LocalDateTime date;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Collection<Comment> getChildrenComment() {
        return childrenComment;
    }

    public void setChildrenComment(Collection<Comment> childrenComment) {
        this.childrenComment = childrenComment;
    }
}
