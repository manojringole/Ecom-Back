package com.infosys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	//custom query
	public Optional<User> findByEmail(String email);
	
/*	public List<User> findByName(String name);
	
	public User findByEmailAndPassword(String email, String password);
	
	public List<User> findByActiveTrue();
	
	public List<User> findByAboutIsNotNull();*/
	
	

}
