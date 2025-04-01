package com.example.multiModule.common.spring.aggregation;

import com.example.multiModule.common.spring.services.ChatService;
import com.example.multiModule.common.spring.services.MessageService;
import com.example.multiModule.common.spring.services.PostsService;
import com.example.multiModule.common.spring.services.UserService;

public interface Aggregation {

    PostsService postsService = new PostsService();

    UserService userService = new UserService();

    ChatService chatService = new ChatService();

    MessageService messageService = new MessageService();
}
