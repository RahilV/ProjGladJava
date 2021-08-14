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

import com.lti.gladiator.finance.beans.EmiCard;
import com.lti.gladiator.finance.services.EmiCardServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class EmiCardController {


	@Autowired
	private EmiCardServiceImpl emiCardService;
	
	//http://localhost:8090/api/v1/emiCard
	
	@GetMapping("/emiCard")
	public List<EmiCard> getEmiCard()
	{
		System.out.println("Inside Controller");
		
		List<EmiCard> empList = emiCardService.getEmiCard();
		return empList;
	}
	
	//http://localhost:8090/api/v1/emiCard/100000000001
	
	@GetMapping(path="/emiCard/{id}", produces="application/json")
	public EmiCard getEmpById(@PathVariable(value="id") long cardNo) {
		return emiCardService.findEmiCardByNo(cardNo);
	}
	
	//http://localhost:8090/api/v1/addnewEmiCard

	@PostMapping("/addnewEmiCard")
	
	public long saveEmiCard(@RequestBody EmiCard ec){
		emiCardService.saveEmiCard(ec);
		return ec.getCardNo();
	}
	
}