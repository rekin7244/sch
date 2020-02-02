package com.kh.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.scheduler.model.ToDo;
import com.kh.scheduler.model.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoRepository toDoRepository;
	
	public Optional<ToDo> selectById(final long id) {
		return toDoRepository.findById(id);
	}
	
	public List<ToDo> selectByAuthor(final String author) {
		return toDoRepository.findByAuthor(author);
	}
	
	public ToDo insertToDo(final ToDo toDo) {
		if(toDo == null) {
			throw new NullPointerException("To Do cannot be null.");
		}
		return toDoRepository.save(toDo);
	}
	
	public ToDo updateToDo(ToDo toDo) {
		if(toDo == null) {
			throw new NullPointerException("To Do cannot be null.");
		}
		return toDoRepository.save(toDo);
	}
	
	public void deleteToDo(final long id) throws Exception {
		Optional<ToDo> todo = toDoRepository.findById(id);
		System.out.println("optional todo : "+todo.get());
		
		if(todo.isPresent()) {
			toDoRepository.delete(todo.get());
		} else {
			throw new Exception("Unexpected Error occured");
		}
	}
}
