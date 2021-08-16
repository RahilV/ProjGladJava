package com.lti.gladiator.finance.services;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.Transactions;
import com.lti.gladiator.finance.dao.TransactionDao;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionDao transactionDao;
	
	

	public TransactionDao getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public int showTransaction(Transaction t) {
		System.out.println("\nService Layer: "+t);
		transactionDao.showTransaction(t);	
		return 0;
	}

	@Override
	public List<Transactions> getTransaction() {
		System.out.println("\nGet  Transactions: Service Layer");
		return transactionDao.getTransaction();
		
	}

	@Override
	public int latestTransactions(int productsPurchasedId) {
		System.out.println("\n Get latest Transaction");
		return transactionDao.latestTransactions(productsPurchasedId);
	}
	
	@Override
	public List<Transactions> getTransactionsById(int productsPurchasedId) {
		System.out.println("\n Get Transaction by Id");
		return transactionDao.getTransactionsById(productsPurchasedId);
	}

	@Override
	public Transactions setTransactions(Transactions transaction) {
		return transactionDao.setTransactions(transaction);
	}

}