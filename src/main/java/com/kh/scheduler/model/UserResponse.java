package com.kh.scheduler.model;

import java.util.List;

import com.kh.scheduler.api.ApiResponse;
import com.kh.scheduler.model.ToDoResponse.ToDoResponseBuilder;

import lombok.Builder;

public class UserResponse extends ApiResponse<String>{

	@Builder
	public UserResponse(final String str, final List<String> errors) {
		super(str);
		this.setErrors(errors);
	}
}
