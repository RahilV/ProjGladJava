package com.lti.gladiator.finance.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.Users;
import com.lti.gladiator.finance.dao.UserDao;
import com.lti.gladiator.finance.exp.UserNotFoundException;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int createUser(Users user) {
		return userDao.createUser(user);
	}

	@Override
	public Users getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public int loginUser(String username, String password) throws UserNotFoundException {
		System.out.println("SERIVCE LAYER: " +username + password);
		return userDao.loginUser(username, password);
	}

}
