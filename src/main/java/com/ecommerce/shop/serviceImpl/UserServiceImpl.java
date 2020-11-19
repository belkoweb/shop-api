package com.ecommerce.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.shop.dao.UserDao;
import com.ecommerce.shop.model.User;
import com.ecommerce.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findByLogin(String login) {
		return userDao.findByLogin(login).orElse(null);
	}


	@Override
	public User saveUser(final User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}

}
