package com.cjx913.springbootdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //多对一关联关系
    @ManyToOne
    //与一的一方的关联属性，
    // @JoinColumn设置关联关系的外键
    //unique表示唯一性
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToOne
    @JoinColumn(name="actor_id",unique = true)
    private Actor actor;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Movie movie, Actor actor) {
        this.name = name;
        this.movie = movie;
        this.actor = actor;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
