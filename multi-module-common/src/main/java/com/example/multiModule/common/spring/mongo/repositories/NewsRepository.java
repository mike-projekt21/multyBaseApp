package com.example.multiModule.common.spring.mongo.repositories;

import com.example.multiModule.common.spring.mongo.entities.News;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewsRepository extends MongoRepository<News, String> {
    List<News> findByUserLogin(String userLogin);
}
