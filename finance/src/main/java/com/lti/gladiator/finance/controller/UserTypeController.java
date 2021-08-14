package com.lti.gladiator.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.gladiator.finance.beans.UserTypes;
import com.lti.gladiator.finance.services.UserTypeServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class UserTypeController {
	
	@Autowired
	private UserTypeServiceImpl userTypeService;
	
	@GetMapping(path="/usertype",produces="application/json")
	public UserTypes getUserTypeConsumer()
	{
		return userTypeService.getUserTypeConsumer();
	}
}
