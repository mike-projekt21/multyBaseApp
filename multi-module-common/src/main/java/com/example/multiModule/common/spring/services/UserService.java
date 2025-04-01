package com.example.multiModule.common.spring.services;

import com.example.multiModule.common.spring.neo4j.entities.User;
import com.example.multiModule.common.spring.neo4j.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> recommendedFriends(Long userLogin) {
		return userRepository.findFriendOfFriend(userLogin);
	}
}
