package com.dao;

import java.util.List;

import com.domain.User;

public interface UserDao {
	public Integer add(User user) throws Throwable;
	public Integer delete(int id) throws Throwable;
	public Integer update(User user) throws Throwable;
	public User get(User user) throws Throwable;
	public List<User> list(User user) throws Throwable;
	
}
