package com.example.multiModule.common.spring.postgres.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "news")
public class News {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "news_text")
	private String newsText;

	@ManyToOne
	@JoinColumn(name="user_login")
	private User user;

	public static News getDefaultNews(String userLogin) {
		return News.builder()
				.title("New news post")
				.newsText(randomAlphabetic(100))
				.build();
	}
}
