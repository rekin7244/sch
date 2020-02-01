package com.kh.scheduler.model;

import java.util.List;

import com.kh.scheduler.api.ApiResponse;
import com.kh.scheduler.model.ToDoResponse.ToDoResponseBuilder;

import lombok.Builder;

public class UserResponse extends ApiResponse<User>{

	@Builder
	public UserResponse(final User user, final List<String> errors) {
		super(user);
		this.setErrors(errors);
	}
}
