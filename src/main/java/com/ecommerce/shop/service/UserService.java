package com.ecommerce.shop.service;

import java.util.List;

import com.ecommerce.shop.model.User;

public interface UserService {
	public List<User> findAll();

	public User findByLogin(String login);

	public User saveUser(User user);
}
