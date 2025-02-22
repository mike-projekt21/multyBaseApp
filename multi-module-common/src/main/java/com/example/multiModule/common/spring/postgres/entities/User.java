package com.example.multiModule.common.spring.postgres.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.multiModule.common.spring.utils.Generators.generateRandomFio;
import static com.example.multiModule.common.spring.utils.Generators.generateRandomPhoneNumber;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

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
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> newsIds = new ArrayList<>();

	public static User getRandomUser() {
		return User.builder()
				.login(randomAlphabetic(10))
				.password(randomAlphabetic(10))
				.fio(generateRandomFio())
				.mobilePhone(generateRandomPhoneNumber())
				.build();
	}
}
