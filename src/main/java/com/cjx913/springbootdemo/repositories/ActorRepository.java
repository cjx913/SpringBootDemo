package com.cjx913.springbootdemo.repositories;

import com.cjx913.springbootdemo.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {
}
