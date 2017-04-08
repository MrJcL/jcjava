package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.domain.User;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao dao;
	@Override
	public List<User> listUserByName(String name) throws Throwable {
		User user=new User();
		user.setName(name);
		System.out.println("asdasd"+dao.list(user));
		return dao.list(user);
	}

}
