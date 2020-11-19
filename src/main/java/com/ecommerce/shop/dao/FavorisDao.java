package com.ecommerce.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shop.model.Favoris;
import com.ecommerce.shop.model.Produit;
import com.ecommerce.shop.model.User;

public interface FavorisDao extends JpaRepository<Favoris, Long> {
	public Favoris findByUserAndProduit(User user, Produit produit);

	public List<Favoris> findAllByUser(User user);
}
