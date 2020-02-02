package com.kh.scheduler.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, String> {

	Optional<ToDo> findById(long id);
	
	List<ToDo> findByAuthor(String author);
	
}
