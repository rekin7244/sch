package com.kh.scheduler.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.scheduler.model.User;
import com.kh.scheduler.model.UserAdapter;
import com.kh.scheduler.model.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "user", description = "����� CRUD �� �����ϴ� API")
public class UserController {
	
	@ApiOperation(value = "user", notes = "����� �߰�")
	@ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successfully create user"),
			@io.swagger.annotations.ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@io.swagger.annotations.ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PostMapping(value = "/user")
    public @ResponseBody UserResponse createUser(@RequestBody User user) {
		List<String> errors = new ArrayList<>();
		
		return UserAdapter.toUserResponse("create user", errors);  	
    }
	
	@ApiOperation(value = "user", notes = "����� ��ȸ")
	@ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successfully Read user"),
			@io.swagger.annotations.ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@io.swagger.annotations.ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@GetMapping(value = "/user")
    public @ResponseBody UserResponse readUser(String userid) {
		List<String> errors = new ArrayList<>();
		
		return UserAdapter.toUserResponse("read user", errors);  	
    }
	
	@ApiOperation(value = "user", notes = "����� ����")
	@ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successfully update user"),
			@io.swagger.annotations.ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@io.swagger.annotations.ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@PutMapping(value = "/user")
    public @ResponseBody UserResponse updateUser(@RequestBody User user) {
		List<String> errors = new ArrayList<>();
		System.out.println("into addUser");
		return UserAdapter.toUserResponse("update user", errors);  	
    }
	
	@ApiOperation(value = "user", notes = "����� ����")
	@ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Successfully delete user"),
			@io.swagger.annotations.ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@io.swagger.annotations.ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@io.swagger.annotations.ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@DeleteMapping(value = "/user")
    public @ResponseBody UserResponse addUser(String userId) {
		List<String> errors = new ArrayList<>();
		
		return UserAdapter.toUserResponse("delete user", errors);  	
    }

}