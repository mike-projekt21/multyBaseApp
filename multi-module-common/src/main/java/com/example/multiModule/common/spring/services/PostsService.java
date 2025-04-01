package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.mongo.entities.Posts;
import com.example.multiModule.common.spring.mongo.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {
	@Autowired
	PostsRepository postsRepository;
	
	public List<Posts> findAll() {
		return postsRepository.findAll();
	}
	public Posts save(Posts posts) {
		return postsRepository.save(posts);
	}
	public List<Posts> findAllByLogin(String login) {
		return postsRepository.findByUserLogin(login);
	}

}
