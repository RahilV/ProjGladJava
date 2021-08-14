package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.Consumer;

@Repository("consumerDao")
@EnableTransactionManagement
public class ConsumerDaoImpl implements ConsumerDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Consumer createConsumer(Consumer consumer) {
		em.persist(consumer);
		System.out.println("USER ADDED");
		return consumer;
	}

	@Override
	public List<Consumer> getAllConsumers() {
		String sql = "Select c from Consumer c WHERE c.user.userType=2";
		TypedQuery<Consumer> tq = em.createQuery(sql,Consumer.class);
		List<Consumer> myConsumers = tq.getResultList();
		System.out.println(myConsumers);
		return myConsumers;
	}

	@Override
	public Consumer getConsumerById(int userId) {
		
		return null;
	}

	@Override
	public List<Consumer> getAllNonValidConsumers() {
		String sql = "Select c from Consumer c WHERE c.isValidated = 'N' AND c.user.userType=2";
		TypedQuery<Consumer> tq = em.createQuery(sql,Consumer.class);
		List<Consumer> myConsumers = tq.getResultList();
		System.out.println(myConsumers);
		return myConsumers;
	}
}
