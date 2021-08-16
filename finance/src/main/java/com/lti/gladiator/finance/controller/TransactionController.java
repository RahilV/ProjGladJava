package com.lti.gladiator.finance.controller;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.gladiator.finance.beans.ProductsPurchased;
import com.lti.gladiator.finance.beans.Transactions;
import com.lti.gladiator.finance.services.TransactionServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1")
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl transactionService;
	
	//http://localhost:8090/api/v1/transaction
	
	@GetMapping("/transactions")
	public List<Transactions> getTransaction()
	{
		System.out.println("Inside Controller");
		
		List<Transactions> transactionList = transactionService.getTransaction();
		return transactionList;
	}

	 //http://localhost:8090/api/v1/latestTransaction/1000001

    @GetMapping(path="/latestTransaction/{id}",produces="application/json")
    public int latestTransaction(@PathVariable(value="id") int productsPurchasedId) {
        return transactionService.latestTransactions(productsPurchasedId);
    }
    
//http://localhost:8090/api/v1/transactionsById/1000001
    
    @GetMapping(path="/transactionsById/{id}",produces="application/json")
    public List<Transactions> getTransactionsById(@PathVariable(value="id") int productsPurchasedId) {
    	List<Transactions> transactionList = transactionService.getTransactionsById(productsPurchasedId);
		return transactionList;
    }
    
    @PostMapping(path="/transactions")
    public Transactions setTransactions(@RequestBody Transactions transaction)
    {
    	Transactions t = transactionService.setTransactions(transaction);
		return t;
    }
	
}