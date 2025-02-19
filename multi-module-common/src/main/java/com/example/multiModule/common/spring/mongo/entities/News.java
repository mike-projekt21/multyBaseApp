package com.example.multiModule.common.spring.mongo.entities;

import com.example.multiModule.common.spring.postgres.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static com.example.multiModule.common.spring.utils.Generators.generateRandomFio;
import static com.example.multiModule.common.spring.utils.Generators.generateRandomPhoneNumber;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "news")
public class News {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Field("title")
	private String title;

	@Field("text")
	private String text;

	@Field("user_login")
	private String userLogin;

	public static News getDefaultNews(String userLogin) {
		return News.builder()
				.title("New news post")
				.text("wefbwyuibferwyberfubwrefubreuybfberufbue")
				.userLogin(userLogin)
				.build();
	}
}
