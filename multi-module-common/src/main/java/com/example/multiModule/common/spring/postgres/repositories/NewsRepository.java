package com.example.multiModule.common.spring.postgres.repositories;

import com.example.multiModule.common.spring.postgres.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {
    List<News> findByUserLogin(String userLogin);
}
