package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.mongo.entities.News;
import com.example.multiModule.common.spring.mongo.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
	@Autowired
	NewsRepository newsRepository;
	
	public List<News> findAll() {
		return newsRepository.findAll();
	}
	public News save(News news) {
		return newsRepository.save(news);
	}
}
