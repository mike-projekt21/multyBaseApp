package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.cassandra.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
}
