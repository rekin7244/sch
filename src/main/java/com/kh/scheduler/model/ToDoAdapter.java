package com.kh.scheduler.model;

import java.util.List;

public class ToDoAdapter {
	
	public static ToDoResponse toToDoResponse(final ToDo toDo, final List<String> errors) {
		return ToDoResponse.builder().toDo(toDo).errors(errors).build();
	}
}
