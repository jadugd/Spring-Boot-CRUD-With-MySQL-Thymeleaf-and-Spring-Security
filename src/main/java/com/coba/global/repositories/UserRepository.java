package com.coba.global.repositories;

import com.coba.global.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameLike(String name);
}
