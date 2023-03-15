package com.infosys.service;

import java.util.List;

import com.infosys.dto.UserDto;

public interface UserService {

	
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto updateUser(UserDto userDto,Integer userId);
	
	public void delete(Integer userId);
	
	public UserDto getUser(Integer userId);
	
	public List<UserDto> getAllUser();
	
	public UserDto getByEmail(String email);
	
}
