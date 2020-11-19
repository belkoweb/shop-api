package com.ecommerce.shop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shop.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	public User findByLoginAndPassword(String login, String password);

	public Optional<User> findByLogin(String login);
}
