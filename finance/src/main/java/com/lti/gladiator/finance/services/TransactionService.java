package com.lti.gladiator.finance.services;

import java.util.List;

import javax.transaction.Transaction;

import com.lti.gladiator.finance.beans.Transactions;


public interface TransactionService {
	
	public int showTransaction(Transaction t);
	
	public List<Transactions> getTransaction();
	
	public int latestTransactions(int productsPurchasedId);
	
	public List<Transactions> getTransactionsById(int productsPurchasedId);
	
	public Transactions setTransactions(Transactions transaction);

}
