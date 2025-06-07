package com.example.multiModule.common.spring.cassandra.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Message {
    @PrimaryKey
    Integer id;
    String userLogin;
    String content;
}
