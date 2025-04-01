package com.example.multiModule.common.spring.mongo.repositories;

import com.example.multiModule.common.spring.mongo.entities.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostsRepository extends MongoRepository<Posts, String> {
    List<Posts> findByUserLogin(String userLogin);
}
