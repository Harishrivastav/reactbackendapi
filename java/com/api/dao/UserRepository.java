package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
