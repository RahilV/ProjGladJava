package com.lti.gladiator.finance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.gladiator.finance.beans.UserTypes;
import com.lti.gladiator.finance.dao.UserTypeDao;

@Service("userTypeService")
public class UserTypeServiceImpl implements UserTypeService{

	@Autowired
	private UserTypeDao userTypeDao;
	
	public UserTypeDao getUserTypeDao() {
		return userTypeDao;
	}
	public void setUserTypeDao(UserTypeDao userTypeDao) {
		this.userTypeDao = userTypeDao;
	}

	@Override
	public UserTypes getUserTypeConsumer() {
		return userTypeDao.getUserTypeConsumer();
	}

}
