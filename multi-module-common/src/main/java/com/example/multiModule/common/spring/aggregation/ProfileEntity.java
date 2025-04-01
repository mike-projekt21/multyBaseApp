package com.example.multiModule.common.spring.aggregation;

import com.example.multiModule.common.spring.mongo.entities.Posts;
import com.example.multiModule.common.spring.neo4j.entities.FriendWith;
import com.example.multiModule.common.spring.neo4j.entities.User;
import com.example.multiModule.common.spring.postgres.entities.Chat;

import java.util.List;

public class ProfileEntity implements Aggregation{
    private Integer id;
    private User user;
    private List<FriendWith> friends = user.getFriendTo();
    private List<Posts> posts = postsService.findAllByLogin(user.getLogin());
    private List<Chat> chats = chatService.findAllByLogin(user.getLogin());
}
