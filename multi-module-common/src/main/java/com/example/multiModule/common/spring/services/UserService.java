package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.neo4j.entities.User;
import com.example.multiModule.common.spring.neo4j.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
	private final UserRepository userRepository;

	public List<User> recommendedFriends(Long userLogin) {
		return userRepository.findFriendOfFriend(userLogin);
	}
}

/*
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
}

 */
