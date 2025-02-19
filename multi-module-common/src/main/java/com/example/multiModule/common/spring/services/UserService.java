package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.postgres.entities.User;
import com.example.multiModule.common.spring.postgres.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	public List<User> findAll() {
		return userRepository.findAll();
	}
	public User save(User user) {
		return userRepository.save(user);
	}
	public User findOne(Integer id) {
		return userRepository.findOne()
	}

}
