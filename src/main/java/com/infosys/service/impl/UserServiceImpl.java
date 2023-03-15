package com.infosys.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.UserDto;
import com.infosys.exception.ResourceNotFoundException;
import com.infosys.model.User;
import com.infosys.repository.UserRepository;
import com.infosys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.mapper.map(userDto, User.class);

		User save = this.repository.save(user);

		return this.mapper.map(save, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.repository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"+userId));
	
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAddress(userDto.getAddress());
		user.setGender(userDto.getGender());
		user.setAbout(userDto.getAbout());
		user.setPhone(userDto.getPhone());
		user.setCreateAt(userDto.getCreateAt());
		
		User update = this.repository.save(user);
		
		return this.mapper.map(update, UserDto.class);
	}

	
	
	@Override
	public void delete(Integer userId) {
		
		User user = this.repository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invaid User Id"+userId));

		this.repository.delete(user);
	}
	
	

	@Override
	public UserDto getUser(Integer userId) {
		
		User user = this.repository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Invaid User Id"+userId));

		return this.mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		
		List<User> all = this.repository.findAll();
		
		List<UserDto> list = all.stream().map(user -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public UserDto getByEmail(String email) {
		
		User user = this.repository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Invalid User email" ));
		
		return this.mapper.map(user, UserDto.class);
	}

}
