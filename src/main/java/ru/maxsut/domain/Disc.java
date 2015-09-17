package ru.maxsut.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "disc")
public class Disc implements Serializable {

    private int id;
    private String title;
    private int owner;
    private String genre;
    private String description;
    private byte[] imgDisc;
    private String tempOwnerName;
    private User user = new User();
    private Set<Comment> comments = new HashSet<Comment>();

    public Disc() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "owner")
    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "imgDisc")
    public byte[] getImgDisc() {
        return imgDisc;
    }

    public void setImgDisc(byte[] imgDisc) {
        this.imgDisc = imgDisc;
    }

    public String getTempOwnerName() {
        return tempOwnerName;
    }

    public void setTempOwnerName(String tempOwnerName) {
        this.tempOwnerName = tempOwnerName;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    @OneToMany(mappedBy = "disc", fetch = FetchType.EAGER)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }

}