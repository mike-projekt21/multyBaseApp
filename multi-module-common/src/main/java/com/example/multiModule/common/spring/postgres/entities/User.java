package com.example.multiModule.common.spring.postgres.entities;

import com.example.multiModule.common.spring.mongo.entities.News;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;
	
	@Column(name = "fio")
	private String fio;

	@Column(name = "mobile_phone")
	private String mobilePhone;

	@Column(name = "news")
	@Builder.Default
	private List<News> news = new ArrayList<News>();

	public static User getRandomUserEntity() {

		return User.builder()
				.login(generateRandomLogin())
				.password(generateRandomPassword())
				.fio(generateRandomFio())
				.mobilePhone(generateRandomPhoneNumber())
				.build();
	}
}
