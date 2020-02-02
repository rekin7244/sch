package com.kh.scheduler.model;

import java.util.List;
import java.util.Optional;

public class ToDoAdapter {
	
	public static ToDoResponse toToDoResponse(final ToDo toDo, final List<String> errors) {
		return ToDoResponse.builder().toDo(toDo).errors(errors).build();
	}
	
	public static ToDo toToDo(final ToDoRequest toDoRequest, String author) {
		if(toDoRequest == null) {
			return null;
		}
		return ToDo.builder()
				.title(toDoRequest.getTitle())
				.done(toDoRequest.getDone())
				.author(author)
				.build();
	}

	public static ToDo updateTodo(ToDoRequest toDoRequest, ToDo oldToDo) {
		if(toDoRequest == null) {
			return null;
		}
		return ToDo.builder()
				.id(oldToDo.getId())
				.title(toDoRequest.getTitle())
				.done(toDoRequest.getDone())
				.author(oldToDo.getAuthor())
				.build();
	}
}
