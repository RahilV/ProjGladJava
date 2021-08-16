package com.lti.gladiator.finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.gladiator.finance.beans.Users;
import com.lti.gladiator.finance.exp.UserNotFoundException;
import com.lti.gladiator.finance.services.UserServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	@GetMapping(path="/users",produces="application/json")
	public List<Users> getUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping(path="/user/{id}",produces="application/json")
	public Users getUserById(@PathVariable(value="id") int userId)
	{
		Users user = userService.getUser(userId);
		return user;
	}
	
	@PostMapping("/users")
	public int saveUser(@RequestBody Users user) {
		return userService.createUser(user);
	}	
	
	@PostMapping("/login")
	public int loginUser(@RequestBody Users user) throws UserNotFoundException
	{
		return userService.loginUser(user.getUserName(), user.getPassword());
	}
}
