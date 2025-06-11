package com.example.multiModule.common.spring.cassandra.entities;

import com.example.multiModule.common.spring.mongo.entities.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "message")
public class Message {
    @PrimaryKey("id")
    Integer id;
    String userLogin;
    String content;
}
