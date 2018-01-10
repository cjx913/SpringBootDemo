package com.cjx913.springbootdemo.repositories;

import com.cjx913.springbootdemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    //Jpa的数据库操作
    public Movie findByName(String name);
    public List<Movie> findByNameLike(String name);
}
