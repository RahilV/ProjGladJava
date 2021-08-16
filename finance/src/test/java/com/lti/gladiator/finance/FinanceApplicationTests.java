package com.lti.gladiator.finance;





import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.gladiator.finance.controller.ConsumerController;

import com.lti.gladiator.finance.exp.UserNotFoundException;
import com.lti.gladiator.finance.services.UserService;



@SpringBootTest
class FinanceApplicationTests {
	
@Autowired
private UserService service;

	@Test
	public void testLoginUserNotFound() {
		Throwable exception = assertThrows(UserNotFoundException.class, () -> {
            service.loginUser("rahilv","rahil123");
			//user.setUserName("rahilv");
			//user.setPassword("rahil123");	
		});
		org.junit.jupiter.api.Assertions.assertEquals("USER NOT FOUND", exception.getMessage());	
					
	}
	

}
