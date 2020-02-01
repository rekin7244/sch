package com.kh.scheduler.api;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {

	private T data;
	private List<String> errors;

	public ApiResponse(T data) {
		super();
		this.data = data;
	}
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
