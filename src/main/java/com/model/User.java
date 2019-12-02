package com.model;


import com.utils.CryptoUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    public User(String email, String password, City city, Race race, Date birhDay, Date createDay, Date lastVisit) {
        this.email = email;
        this.password = password;
        this.city = city;
        this.race = race;
        this.birhDay = birhDay;
        this.createDay = createDay;
        this.lastVisit = lastVisit;
        this.hashPass = CryptoUtils.hashPassSHA256withSalt(password, "lobster");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_email", nullable = false,unique = true, length = 40)
    private String email;

    @Transient
    private String password;

    @Column(name = "hash_password", nullable = false)
    private String hashPass;

    @Enumerated(EnumType.STRING)
    private City city;

    @Enumerated(EnumType.STRING)
    private Race race;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birhDay;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDay;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastVisit;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Date getBirhDay() {
        return birhDay;
    }

    public void setBirhDay(Date birhDay) {
        this.birhDay = birhDay;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", city=" + city +
                ", race=" + race +
                ", birhDay=" + birhDay +
                ", createDay=" + createDay +
                ", lastVisit=" + lastVisit +
                '}';
    }
}
