package com.example.multiModule.sampleDbAccess;

import java.util.List;

import com.example.multiModule.common.spring.mongo.entities.News;
import com.example.multiModule.common.spring.postgres.entities.User;
import com.example.multiModule.common.spring.services.NewsService;
import com.example.multiModule.common.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.multiModule.common.spring.mongo.entities.MongoSample;
import com.example.multiModule.common.spring.postgres.entities.PostgresSample;
import com.example.multiModule.common.spring.services.MongoSampleService;
import com.example.multiModule.common.spring.services.PosgresSampleService;

@SpringBootApplication
@ComponentScan(basePackages = { "${packages.common.component}", "${app.packages}" })
public class SampleDbAccessApp implements ApplicationRunner {
	@Autowired
	PosgresSampleService postgresSampleService;
	@Autowired
	MongoSampleService mongoSampleService;
	@Autowired
	NewsService newsService;
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleDbAccessApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User testUser = createUser();
		System.out.println(testUser);
		//createNews(testUser);
	}

	public void createNews(User user){
		News news = News.getDefaultNews(user.getLogin());
		//user.getNewsIds().add(news.getId());
		newsService.save(news);
		//userService.findOne(user.getId());
		userService.save(user);

	}

	public User createUser(){
		User user = User.getRandomUser();
		userService.save(user);
		return user;
	}
/*
	@Override
	public void run(ApplicationArguments args) throws Exception {
		PostgresSample postgre = new PostgresSample();
		postgre.setName("John");
		postgresSampleService.save(postgre);
		List<PostgresSample> findResult1 = postgresSampleService.findAll();
		findResult1.forEach(System.out::println);
		
		MongoSample mongo = new MongoSample();
		mongo.setName("Kate");
		mongoSampleService.save(mongo);
		List<MongoSample> findResult2 = mongoSampleService.findAll();
		findResult2.forEach(System.out::println);
	}
 */
}

