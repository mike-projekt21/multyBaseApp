package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.mongo.entities.Posts;
import com.example.multiModule.common.spring.postgres.entities.Chat;
import com.example.multiModule.common.spring.postgres.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    public List<Chat> findAllByLogin(String login) {
        return chatRepository.findByUserLogin(login);
    }
}
