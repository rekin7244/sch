package com.kh.scheduler.service;

import org.springframework.stereotype.Service;

import com.kh.scheduler.model.ToDo;

@Service
public class ToDoService {
	
	public ToDo get(final String id) {
		// do id validation
		return ToDo.builder()
				.title("Add an id validation")
				.build();
	}
}
