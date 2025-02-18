package com.example.multiModule.common.spring.postgres.repositories;

import com.example.multiModule.common.spring.postgres.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
