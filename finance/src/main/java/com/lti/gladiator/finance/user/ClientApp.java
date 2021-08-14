package com.lti.gladiator.finance.user;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.gladiator.finance.beans.EmiCard;
import com.lti.gladiator.finance.services.EmiCardService;

public class ClientApp {
	
public static void main(String[] args) {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-Config.xml");
	EmiCardService service = ctx.getBean("emiCardService",EmiCardService.class);
	
	// Create/Insert
	EmiCard ec= new EmiCard(100000000004L,"Gold",50000,Date.valueOf("01/01/2023"));
	
	service.saveEmiCard(ec);
	
	System.out.println(ec);
}
}
