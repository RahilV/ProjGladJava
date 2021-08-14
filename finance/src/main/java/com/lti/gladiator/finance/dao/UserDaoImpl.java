package com.lti.gladiator.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lti.gladiator.finance.beans.Users;
import com.lti.gladiator.finance.exp.UserNotFoundException;

@Repository("userDao")
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public int createUser(Users user) {		
		em.persist(user);
		System.out.println("USER ADDED");
		return user.getUserId();
	}

	@Override
	public Users getUser(int userId) 
	{	
		Users fetchedUser = em.find(Users.class,userId);
		System.out.println(fetchedUser);
		return fetchedUser;
	}

	@Override
	public List<Users> getAllUsers() {
		String sql = "Select u from Users u";
		TypedQuery<Users> tq = em.createQuery(sql,Users.class);
		List<Users> myUsers = tq.getResultList();
		return myUsers;
	}

	@Override
	public int loginUser(String uname, String password) throws UserNotFoundException{
		String sql = "Select u from Users u WHERE u.userName=:uname AND u.password=:pwd";
		TypedQuery<Users> tq = em.createQuery(sql,Users.class);
		tq.setParameter("uname",uname);
		tq.setParameter("pwd",password);
		Users user = null;
		try {
			user = tq.getSingleResult();
		}
		catch (Exception e) {
			throw new UserNotFoundException("USER NOT FOUND");
		}
		return user.getUserId();
	}

}
