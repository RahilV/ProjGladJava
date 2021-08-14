package com.lti.gladiator.finance.controller;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.gladiator.finance.beans.Consumer;
import com.lti.gladiator.finance.beans.EmiCard;
import com.lti.gladiator.finance.beans.UserTypes;
import com.lti.gladiator.finance.beans.Users;
import com.lti.gladiator.finance.services.ConsumerServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class ConsumerController {

	@Autowired
	private ConsumerServiceImpl consumerService;
	
	@Autowired
	private UserController userControl;
	
	@Autowired
	private EmiCardController cardControl;
	
	@Autowired
	private UserTypeController userTypeControl;
	
	
	@PostMapping("/consumers")
	public Consumer saveConsumer(@RequestBody Consumer consumer) {
		Consumer c = new Consumer();
		String userName = consumer.getUser().getUserName();
		String email = consumer.getUser().getEmail();
		String password = consumer.getUser().getPassword();
		
		
		UserTypes getUserType = userTypeControl.getUserTypeConsumer();
		
		try {
			Users newUser = new Users(getUserType,userName,email,password);
			userControl.saveUser(newUser);
			System.out.println("USER :"+newUser);
			
			String cardTypeName = consumer.getCardNo().getCardTypeName();
			int cardsLimit = consumer.getCardNo().getCardLimit();
			Date cardValidity = consumer.getCardNo().getValidity();
			
			//CALL EMI CARD CONTROLLER TO ADD CARD
			EmiCard newCard = new EmiCard(cardTypeName,cardsLimit,cardValidity);
			System.out.println("EMI CARD :"+newCard);
			
			c.setUser(newUser);
			c.setAddress(consumer.getAddress());
			c.setBalance(consumer.getBalance());
			c.setCardNo(newCard);
			c.setfName(consumer.getfName());
			c.setlName(consumer.getlName());
			c.setIfscCode(consumer.getIfscCode());
			c.setIsValidated(consumer.getIsValidated());
			c.setPhoneNo(consumer.getPhoneNo());
			c.setSavingAccNo(consumer.getSavingAccNo());
			
			consumerService.createConsumer(c);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return c;
	}
	
	@GetMapping(path="/consumers",produces="application/json")
	public List<Consumer> getAllConsumers()
	{
		return consumerService.getAllConsumers();
	}
	
	/*@GetMapping(path="/consumer/{id}",produces="application/json")
	public Consumer getUserById(@PathVariable(value="id") int consumerId)
	{
		Consumer user = consumerService.get(consumerId);
		return user;
	}*/
	
		
}
