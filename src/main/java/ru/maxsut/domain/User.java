package ru.maxsut.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User implements Serializable {

    private int id;

    @NotEmpty @Size(min = 2, max = 30)
    private String name;

    @NotEmpty @Size(min = 2, max = 70)
    private String password;

    @NotEmpty @Email
    private String email;

    private byte[] photo;

    private String state = State.ACTIVE.getState();

    private Set<Disc> discs = new HashSet<Disc>();

    private Set<UserProfile> userProfile = new HashSet<UserProfile>();

    public User() {
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

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "STATE", nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    @ManyToMany
//    @JoinTable(name = "user_disc_details",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "disc_id"))

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    public Set<Disc> getDiscs() {
        return discs;
    }

    public void setDiscs(Set<Disc> discs) {
        this.discs = discs;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "app_user_user_profile",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "user_profile_id"))
    public Set<UserProfile> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(Set<UserProfile> userProfile) {
        this.userProfile = userProfile;
    }
}
