package com.kh.scheduler.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@Api(tags = "todo", description = "할일 CRUD")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	@ApiOperation(value = "할일 전체 조회" , notes = "할일 전체 조회")
	@GetMapping(value = "/todo")
	@GroupedApiResponses
	public @ResponseBody List<ToDoResponse> selectToDoList() {
		List<String> errors = new ArrayList<>();
		List<ToDo> toDoList = toDoService.getAll();
		List<ToDoResponse> toDoResponses = new ArrayList<>();
		toDoList.stream().forEach(toDo -> {
			toDoResponses.add(ToDoAdapter.toToDoResponse(toDo, errors));
		});
		return toDoResponses;
	}
	
	@ApiOperation(value = "할일 조회" , notes = "할일 조회")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "할일 고유키", required = true, dataType = "string", paramType = "path", defaultValue = "")
	})
	@GroupedApiResponses
	@GetMapping(value = "/todo/{id}")
	public @ResponseBody ToDoResponse selectOneToDo(@PathVariable(value = "id") String id) {
		List<String> errors = new ArrayList<>();
		ToDo toDo = null;
		
		try {
			toDo = toDoService.get(id);
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(toDo, errors);
	}
	
	@ApiOperation(value = "할일 추가" , notes = "할일 추가")
	@GroupedApiResponses
	@PostMapping(value = "/todo")
	public @ResponseBody ToDoResponse insertToDo(@RequestBody final ToDoRequest toDoRequest) {
		List<String> errors = new ArrayList<>();
		ToDo toDo = ToDoAdapter.toToDo(toDoRequest);
		
		try {
			toDo = toDoService.create(toDo);
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(toDo, errors);
	}
	
	@ApiOperation(value = "할일 수정" , notes = "할일 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "toDoRequest", value = "수정할 할일", required = true, dataType = "ToDo", paramType = "query", defaultValue = "")
	})
	@GroupedApiResponses
	@PutMapping(value = "/todo")
	public @ResponseBody ToDoResponse updateToDo(@RequestBody final ToDoRequest toDoRequest) {
		List<String> errors = new ArrayList<>();
		ToDo toDo = ToDoAdapter.toToDo(toDoRequest);
		
		try {
			// update logic
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(toDo, errors);
	}
	
	@ApiOperation(value = "할일 삭제" , notes = "할일 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "할일 고유키", required = true, dataType = "string", paramType = "path", defaultValue = "")
	})
	@GroupedApiResponses
	@DeleteMapping(value = "/todo")
	public @ResponseBody ToDoResponse deleteToDo(@PathVariable(value = "id") String id) {
		List<String> errors = new ArrayList<>();
		ToDo toDo = null;
		
		try {
			// delete logic
		} catch (final Exception e) {
			errors.add(e.getMessage());
		}
		return ToDoAdapter.toToDoResponse(toDo, errors);
	}
	
}
