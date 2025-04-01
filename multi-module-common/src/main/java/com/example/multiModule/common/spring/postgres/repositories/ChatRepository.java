package com.example.multiModule.common.spring.postgres.repositories;

import com.example.multiModule.common.spring.postgres.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    List<Chat> findByUserLogin(String userLogin);
}
