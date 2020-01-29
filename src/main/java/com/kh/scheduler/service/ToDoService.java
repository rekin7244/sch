package com.kh.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.scheduler.model.ToDo;
import com.kh.scheduler.model.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	public ToDo get(final String id) {
		return toDoRepository.findById(id).orElse(null);
	}
	
	public ToDo create(final ToDo toDo) {
		if(toDo == null) {
			throw new NullPointerException("To Do cannot be null.");
		}
		return toDoRepository.save(toDo);
	}
	
	public List<ToDo> getAll() {
		return (List<ToDo>)toDoRepository.findAll();
	}
}
