package com.infosys.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.UserDto;
import com.infosys.payload.ApiResponse;
import com.infosys.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		
		userDto.setCreateAt(new Date());
		
		UserDto createUser = service.createUser(userDto);
		
		return new ResponseEntity<UserDto>(createUser,HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
		
		UserDto updateUser = service.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
		
	
	}
	
	
	@GetMapping("/u/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
		
		UserDto user = service.getUser(userId);
		return new ResponseEntity<UserDto>(user,HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
	
		List<UserDto> allUser = service.getAllUser();
		return new ResponseEntity<List<UserDto>>(allUser,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
	
		service.delete(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserDto> UserEmail(@PathVariable String email){
		
		UserDto byEmail = service.getByEmail(email);
		
		return new ResponseEntity<UserDto>(byEmail, HttpStatus.OK);
	}
	
}
