package com.kh.scheduler.model;

import java.util.List;

public class UserAdapter {
	
	public static UserResponse toUserResponse(final User user, final List<String> errors) {
		return UserResponse.builder().user(user).errors(errors).build();
	}
	
	public static User toUser(final UserRequest userRequest) {
		if(userRequest == null) {
			return null;
		}
		return User.builder()
				.userId(userRequest.getUserId())
				.password(userRequest.getPassword())
				.build();
	}

}
