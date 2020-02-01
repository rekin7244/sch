package com.kh.scheduler.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.scheduler.model.User;
import com.kh.scheduler.model.UserRepository;

import javassist.NotFoundException;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User create(User user) {
        if (userRepository.findById(user.getUserId()).isPresent()) {
        	throw new RuntimeException(user.getUserId() + " is an existing");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

	public User read(String userId) {
		if (!userRepository.findById(userId).isPresent()) {
        	throw new RuntimeException(userId + " is not found");
        } else {
        	return userRepository.findById(userId).orElse(null);
        }
	}

}
