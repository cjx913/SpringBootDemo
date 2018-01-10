package com.cjx913.springbootdemo.repositories;

import com.cjx913.springbootdemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
