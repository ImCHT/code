package com.vivohackathon.letsdomaths.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String password;
    private String name;
    private int genanswer;
    private int genright;
    private int cdanswer;
    private int cdright;
    private int matans;
    private int matright;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGenanswer() {
        return genanswer;
    }

    public void setGenanswer(int genanswer) {
        this.genanswer = genanswer;
    }

    public int getGenright() {
        return genright;
    }

    public void setGenright(int genright) {
        this.genright = genright;
    }

    public int getCdanswer() {
        return cdanswer;
    }

    public void setCdanswer(int cdanswer) {
        this.cdanswer = cdanswer;
    }

    public int getCdright() {
        return cdright;
    }

    public void setCdright(int cdright) {
        this.cdright = cdright;
    }

    public int getMatans() {
        return matans;
    }

    public void setMatans(int matans) {
        this.matans = matans;
    }

    public int getMatright() {
        return matright;
    }

    public void setMatright(int matright) {
        this.matright = matright;
    }
}
