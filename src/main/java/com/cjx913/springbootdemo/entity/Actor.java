package com.cjx913.springbootdemo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date born;

    @OneToOne(mappedBy = "actor")
    private Role role;

    public Actor() {
    }



    public Actor(String name, int sex, Date born) {
        this.name = name;
        this.sex = sex;
        this.born = born;
    }

    public Actor(String name, int sex, Date born, Role role) {
        this.name = name;
        this.sex = sex;
        this.born = born;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
