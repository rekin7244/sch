package com.kh.scheduler.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.scheduler.model.User;
import com.kh.scheduler.model.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("userid not found " + userId));
        return UserPrincipal.create(user);	
	}

}
