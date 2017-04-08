package com.service;

import java.util.List;

import com.domain.User;

public interface UserService {
	public List<User> listUserByName(String name) throws Throwable;
}
