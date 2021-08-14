package com.lti.gladiator.finance.dao;

import java.util.List;

import com.lti.gladiator.finance.beans.Users;
import com.lti.gladiator.finance.exp.UserNotFoundException;

public interface UserDao {

	public abstract int createUser(Users user);
	public abstract Users getUser(int userId);
	public abstract List<Users> getAllUsers();
	public abstract int loginUser(String username,String password) throws UserNotFoundException;
}
