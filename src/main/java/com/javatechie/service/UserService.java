package com.javatechie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javatechie.entity.Users;
import com.javatechie.exception.UserNotFoundException;
import com.javatechie.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// private PasswordEncoder passwordEncoder;

	public Users register(Users user) {
		return userRepository.save(user);
	}

	public List<Users> findUser(String email) {
		List<Users> users= userRepository.findByEmail(email);
		return users;
	}

	public Users findLoginUser(int userId, String password) {
		return userRepository.findByIdAndPassword(userId, password);
	}

	public Users findUserById(int userid) {
		
		return userRepository.findById(userid).get();
	}

	public List<Users> cancelRegistration(int id) {
		userRepository.deleteById(id);
		return userRepository.findAll();
	}

	public List<Users> findAllUser() {
		return userRepository.findAll();

	}

}
