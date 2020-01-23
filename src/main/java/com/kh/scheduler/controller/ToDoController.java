package com.kh.scheduler.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.scheduler.model.ToDo;
import com.kh.scheduler.model.ToDoAdapter;
import com.kh.scheduler.model.ToDoResponse;
import com.kh.scheduler.service.ToDoService;

@RestController
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/todo/{id}")
	public @ResponseBody ToDoResponse get(@PathVariable(value = "id") String id) {
		List<String> errors = new ArrayList<>();
		ToDo toDo = null;
		
		try {
			toDo = toDoService.get(id);
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(toDo, errors);
	}
}
