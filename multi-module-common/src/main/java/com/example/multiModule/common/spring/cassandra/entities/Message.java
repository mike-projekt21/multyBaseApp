package com.example.multiModule.common.spring.cassandra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    Integer id;
    String userLogin;
    String content;
}
