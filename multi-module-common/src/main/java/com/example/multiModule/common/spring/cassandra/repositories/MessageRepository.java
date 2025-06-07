package com.example.multiModule.common.spring.cassandra.repositories;

import com.example.multiModule.common.spring.cassandra.entities.Message;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MessageRepository extends CassandraRepository<Message, Integer> {
}
