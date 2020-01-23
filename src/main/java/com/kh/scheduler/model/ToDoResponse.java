package com.kh.scheduler.model;

import java.util.List;

import com.kh.scheduler.api.ApiResponse;

import lombok.Builder;

public class ToDoResponse extends ApiResponse<ToDo>{
	
	@Builder
	public ToDoResponse(final ToDo toDo, final List<String> errors) {
		super(toDo);
		this.setErrors(errors);
	}
	
}
