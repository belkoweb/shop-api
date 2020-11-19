package com.ecommerce.shop.service;

import java.util.List;

import com.ecommerce.shop.model.Favoris;
import com.ecommerce.shop.model.User;

public interface FavorisService {
	public List<Favoris> findAll();

	public Favoris save(Favoris favoris);

	public List<Favoris> findAllByUser(User user);
	
	public void deleteFavoris(Favoris favoris);
}
