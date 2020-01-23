package com.kh.scheduler.api;

import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {

	@NonNull private T data;
	private List<String> errors;
	
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
