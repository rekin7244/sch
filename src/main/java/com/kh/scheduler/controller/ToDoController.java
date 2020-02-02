package com.kh.scheduler.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.scheduler.common.GroupedApiResponses;
import com.kh.scheduler.model.ToDo;
import com.kh.scheduler.model.ToDoAdapter;
import com.kh.scheduler.model.ToDoRequest;
import com.kh.scheduler.model.ToDoResponse;
import com.kh.scheduler.service.ToDoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Api(tags = "todo", description = "할일 CRUD")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	@ApiOperation(value = "할일 전체 조회" , notes = "할일 전체 조회")
	@GetMapping(value = "/todo")
	@GroupedApiResponses
	public @ResponseBody List<ToDoResponse> selectToDoList(Principal principal) {
		List<String> errors = new ArrayList<>();
		List<ToDoResponse> toDoResponses = new ArrayList<>();
		String author = principal.getName();
		
		try {
			List<ToDo> toDoList = toDoService.selectByAuthor(author);
			toDoList.stream().forEach(toDo -> {
				toDoResponses.add(ToDoAdapter.toToDoResponse(toDo, errors));
			});
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return toDoResponses;
	}
	
	@ApiOperation(value = "할일 추가" , notes = "할일 추가")
	@GroupedApiResponses
	@PostMapping(value = "/todo")
	public @ResponseBody ToDoResponse insertToDo(@RequestBody final ToDoRequest toDoRequest, Principal principal) {
		List<String> errors = new ArrayList<>();
		String author = principal.getName();
		ToDo toDo = ToDoAdapter.toToDo(toDoRequest, author);
		try {
			toDo = toDoService.insertToDo(toDo);
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(toDo, errors);
	}
	
	@ApiOperation(value = "할일 수정" , notes = "할일 수정")
	@GroupedApiResponses
	@PutMapping(value = "/todo")
	public @ResponseBody ToDoResponse updateToDo(@RequestBody final ToDoRequest toDoRequest, Principal principal) {
		List<String> errors = new ArrayList<>();
		Optional<ToDo> oldToDo = toDoService.selectById(toDoRequest.getId());
		ToDo newToDo = null;
		
		try {
			if(oldToDo.isPresent()) {
				log.info("update oldToDo : "+oldToDo.get());
				newToDo = ToDoAdapter.updateTodo(toDoRequest, oldToDo.get());
				log.info("update newToDo : "+newToDo);
				newToDo = toDoService.updateToDo(newToDo);
			}
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(newToDo, errors);
	}
	
	@ApiOperation(value = "할일 삭제" , notes = "할일 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "할일 고유키", required = true, dataType = "string", paramType = "path", defaultValue = "")
	})
	@GroupedApiResponses
	@DeleteMapping(value = "/todo/{id}")
	public @ResponseBody String deleteToDo(@PathVariable(value = "id") long id) {
		List<String> errors = new ArrayList<>();
		
		try {
			toDoService.deleteToDo(id);
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return "success";
	}
	
}
