package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.postgres.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;
}
