package com.example.multiModule.common.spring.neo4j.entities;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDate;


@Data
@RelationshipEntity
public class FriendWith {

    @Id
    @GeneratedValue
    private Long id;
    @Property("since")
    private LocalDate date;
    @StartNode
    private User friendTo;

    public FriendWith(User user){
        this.date = LocalDate.now();
        this.friendTo = user;
    }
}
