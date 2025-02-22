package com.example.multiModule.common.spring.mongo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "news")
public class News {
	@Id
	private String id;

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
