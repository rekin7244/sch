package com.kh.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.scheduler.model.User;
import com.kh.scheduler.model.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User add(User user) {
        if (userRepository.findById(user.getUserId()).isPresent()) {
        	throw new RuntimeException(user.getUserId() + "is an existing ID");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
