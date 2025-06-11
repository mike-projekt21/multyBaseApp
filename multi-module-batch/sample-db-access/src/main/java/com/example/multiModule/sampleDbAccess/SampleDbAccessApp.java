package com.example.multiModule.sampleDbAccess;

import com.example.multiModule.common.spring.mongo.entities.Posts;
import com.example.multiModule.common.spring.neo4j.entities.FriendWith;
import com.example.multiModule.common.spring.neo4j.entities.User;
import com.example.multiModule.common.spring.services.MessageService;
import com.example.multiModule.common.spring.services.PostsService;
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
	PostsService postsService;
	@Autowired
	UserService userService;
	@Autowired
	UserService chatService;
	@Autowired
	MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleDbAccessApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {


//		User testUser1 = createUser();
//		User testUser2 = createUser();
//		makeFriends(testUser1, testUser2);
//		User testUser = userService.findAll()
//		createNews("GLBMZZNVAd");
//		findAllNewsByUserLogin("GLBMZZNVAd");
	}

	public void createMessage(String login){
		Posts posts = Posts.getDefaultNews(login);
		postsService.save(posts);
		System.out.println(LocalTime.now() + " " + posts);
	}

/*
	public void createNews(String login){
		Posts posts = Posts.getDefaultNews(login);
		postsService.save(posts);
		System.out.println(LocalTime.now() + " " + posts);
	}

	public User createUser(){
		User user = User.getRandomUser();
		return user;
	}

	public void makeFriends(User user1, User user2){
		user1.getFriendTo().add(new FriendWith(user2));
	}

	public List<Posts> findAllNewsByUserLogin(String login){
		List<Posts> postsList = postsService.findAllByLogin(login);
		System.out.println(postsList);
		return postsList;
	}

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

