package com.javatechie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.dto.UserInfo;
import com.javatechie.entity.Users;
import com.javatechie.security.JwtUtil;
import com.javatechie.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */

	@GetMapping("/generatetoken")
	public String getJwtToken() {
		UserInfo userInfo = new UserInfo();
		return jwtUtil.generateToken(userInfo);
	}

	@PostMapping("/register")
	public String register(@RequestBody Users users) {
		userService.register(users);
		return "Hi " + users.getName() + " your registration was successful";
	}

	@GetMapping("/findLoginUser/{userId}/{password}")
	public String findLoginUser(@PathVariable int userId, @PathVariable String password) {
		UserInfo userInfo = new UserInfo();
		try {
			Users userObj = userService.findUserById(userId);
			userInfo.setId(userObj.getId());
			userInfo.setName(userObj.getName());
			String token = jwtUtil.generateToken(userInfo);
			String userName = jwtUtil.getUserNameFromToken(token);
			if (userName.equals(userObj.getName())) {
				Users user = userService.findLoginUser(userId, password);
				// Users user= userService.findUserById(userId);
				if (null != user) {
					return "Hi " + user.getName() + " your login was successful";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Invalid login attempt";
	}

	@GetMapping("/findUser/{email}")
	public List<Users> findUser(@PathVariable String email) {
		List<Users> users = userService.findUser(email);
		return users;
	}

	@GetMapping(value = "/findUserById/{userid}", produces = { "application/json" })
	public Users findUserById(@PathVariable int userid) {
		Users user = new Users();
		user = userService.findUserById(userid);
		return user;
	}

	@GetMapping("/cancel/{id}")
	public List<Users> cancelRegistration(@PathVariable int id) {
		return userService.cancelRegistration(id);
	}

	@GetMapping(value = "/getAllUsers", produces = { "application/json" })
	public List<Users> findAllUser() {
		return userService.findAllUser();

	}

}
