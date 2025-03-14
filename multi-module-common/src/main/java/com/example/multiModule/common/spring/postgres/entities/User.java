package com.example.multiModule.common.spring.postgres.entities;

import lombok.*;

import javax.persistence.*;

import static com.example.multiModule.common.spring.utils.Generators.generateRandomFio;
import static com.example.multiModule.common.spring.utils.Generators.generateRandomPhoneNumber;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
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

	public static User getRandomUser() {
		return User.builder()
				.login(randomAlphabetic(10))
				.password(randomAlphabetic(10))
				.fio(generateRandomFio())
				.mobilePhone(generateRandomPhoneNumber())
				.build();
	}
}
