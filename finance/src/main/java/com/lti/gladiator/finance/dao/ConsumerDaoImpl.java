package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.Consumer;
import com.lti.gladiator.finance.beans.EmiCard;
import com.lti.gladiator.finance.beans.Users;

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
		String sql = "Select c from Consumer c where c.user.userId=:c_userId";
		TypedQuery<Consumer> tq = em.createQuery(sql,Consumer.class);
		tq.setParameter("c_userId", userId);
		Consumer consumer = tq.getSingleResult();
		System.out.println("EK");
		return consumer;
	}

	@Override
	public List<Consumer> getAllNonValidConsumers() {
		String sql = "Select c from Consumer c WHERE c.isValidated = 'N' AND c.user.userType=2";
		TypedQuery<Consumer> tq = em.createQuery(sql,Consumer.class);
		List<Consumer> myConsumers = tq.getResultList();
		System.out.println(myConsumers);
		return myConsumers;
	}

	@Override
	@Transactional
	public Consumer validateConsumer(int userId) {
		String sql = "Select c FROM Consumer c WHERE c.user.userId=:userId";
		Query tq = em.createQuery(sql);
		tq.setParameter("userId", userId);
		Consumer myConsumer = (Consumer) tq.getSingleResult();
		System.out.println(myConsumer);
		myConsumer.setIsValidated('Y');
		em.merge(myConsumer);
		System.out.println(myConsumer);
		return myConsumer;
	}

	@Override
	@Transactional
	public String deleteConsumer(int userId) {
		/*Consumer c = em.find(Consumer.class, userId);
		System.out.println(c);*/
		em.remove(em.find(Consumer.class, userId));
		return null;
	}

	@Override
	@Transactional
	public Consumer editConsumer(Consumer consumer) {
		
		Consumer c = em.find(Consumer.class, consumer.getUser().getUserId());
		System.out.println("\n\n DATA AAYA"+c);
		c.setfName(consumer.getfName());
		c.setlName(consumer.getlName());
		c.setIfscCode(consumer.getIfscCode());
		c.setSavingAccNo(consumer.getSavingAccNo());
		c.setPhoneNo(consumer.getPhoneNo());
		c.setAddress(consumer.getAddress());
		
		Users user = em.find(Users.class, c.getUser().getUserId());
		user.setUserName(consumer.getUser().getUserName());
		user.setEmail(consumer.getUser().getEmail());
		em.merge(user);
		System.out.println("USER "+user);
		c.setUser(user);
		EmiCard emiCard = em.find(EmiCard.class, c.getCard().getCardNo());
		emiCard.setCardTypeName(consumer.getCard().getCardTypeName());
		em.merge(emiCard);
		c.setCard(emiCard);
		
		
		
		em.merge(c);
		
		System.out.println("\n\n"+c);
		return c;
	}

}
