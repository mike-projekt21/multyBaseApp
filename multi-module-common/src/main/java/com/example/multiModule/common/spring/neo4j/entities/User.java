package com.example.multiModule.common.spring.neo4j.entities;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.multiModule.common.spring.utils.Generators.generateRandomFio;
import static com.example.multiModule.common.spring.utils.Generators.generateRandomPhoneNumber;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@NodeEntity("User")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String login;

    private String password;

    private String fio;

    private String mobilePhone;

    @Relationship(type = "FRIEND_WITH", direction = Relationship.OUTGOING)
    private List<FriendWith> friendTo = new ArrayList<>();

    public static User getRandomUser() {
        return User.builder()
                .login(randomAlphabetic(10))
                .password(randomAlphabetic(10))
                .fio(generateRandomFio())
                .mobilePhone(generateRandomPhoneNumber())
                .build();
    }
}