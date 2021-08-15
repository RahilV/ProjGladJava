package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.ProductsPurchased;
import com.lti.gladiator.finance.beans.Transactions;

@Repository("transactionDao")
@EnableTransactionManagement
public class TransactionDaoImpl implements TransactionDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int showTransaction(Transaction t) {
		System.out.println("\nDao Layer: " + t);

		em.persist(t);

		System.out.println("Record saved");
		return 0;
	}

	public List<Transactions> getTransaction() {
		System.out.println("\nGet Transaction: Dao layer");

		TypedQuery<Transactions> qry = em.createQuery("SELECT e FROM Transactions e", Transactions.class);
		List<Transactions> TransactionList = qry.getResultList();

		return TransactionList;
	}

	@Override
	public int latestTransactions(int productsPurchasedId) {
		System.out.println("\n latest transaction: Dao Layer");

		String sql = "SELECT t FROM Transactions t where t.productPurchased.productPurchasedId = :t_productPurchasedId";
		TypedQuery<Transactions> tq = em.createQuery(sql, Transactions.class);
		tq.setParameter("t_productPurchasedId", productsPurchasedId);
		Transactions t = tq.getSingleResult();
		return t.getTransactionId();
	}
	@Override
	public List<Transactions> getTransactionsById(int productsPurchasedId) {
		
		String sql = "SELECT t FROM Transactions t where t.productPurchased.productPurchasedId = :t_productPurchasedId";
		TypedQuery<Transactions> tq = em.createQuery(sql, Transactions.class);
		tq.setParameter("t_productPurchasedId", productsPurchasedId);
		List<Transactions> TransactionList = tq.getResultList();
		return TransactionList;
	}
}
