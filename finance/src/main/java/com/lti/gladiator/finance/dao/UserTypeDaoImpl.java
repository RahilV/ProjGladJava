package com.lti.gladiator.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.UserTypes;

@Repository("userTypeDao")
@EnableTransactionManagement
public class UserTypeDaoImpl implements UserTypeDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public UserTypes getUserTypeConsumer() {
		UserTypes userType = em.find(UserTypes.class,2);
		return userType;
	}
}
