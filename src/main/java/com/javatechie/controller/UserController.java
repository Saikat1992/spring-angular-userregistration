package com.javatechie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.entity.Users;
import com.javatechie.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public String register(@RequestBody Users users) {
		userRepository.save(users);
		return "Hi "+users.getName()+" your registration was successful";
	}
	
	
	@GetMapping("/findUser/{email}")
	public List<Users> findUser(@PathVariable String email){
		return userRepository.findByEmail(email);
	}
	
	
	@GetMapping("/cancel/{id}")
	public List<Users> cancelRegistration(@PathVariable int id){
		userRepository.deleteById(id);
		return userRepository.findAll();
	}
	
	@GetMapping(value="/getAllUsers")
	public List<Users> findAllUser(){
		return userRepository.findAll();
		
	}
	
	

}
