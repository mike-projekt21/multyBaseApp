package com.example.multiModule.sampleDbAccess;

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

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = { "${packages.common.component}", "${app.packages}" })
public class SampleDbAccessApp implements ApplicationRunner {
	@Autowired
	NewsService newsService;
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleDbAccessApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		for (int i = 0; i<100; i++){
			User testUser = createUser();
			for (int j = 0; j<100; j++){
				createNews(testUser.getLogin());
			}
		}
//		User testUser = createUser();
//		User testUser = userService.findAll()
//		createNews("GLBMZZNVAd");
//		findAllNewsByUserLogin("GLBMZZNVAd");
	}

	public void createNews(String login){
		News news = News.getDefaultNews(login);
		newsService.save(news);
		System.out.println(LocalTime.now() + " " + news);
	}

	public User createUser(){
		User user = User.getRandomUser();
		userService.save(user);
		System.out.println(LocalTime.now() + " " + user);
		return user;
	}

	public List<News> findAllNewsByUserLogin(String login){
		List<News> newsList= newsService.findAllByLogin(login);
		System.out.println(newsList);
		return newsList;
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

