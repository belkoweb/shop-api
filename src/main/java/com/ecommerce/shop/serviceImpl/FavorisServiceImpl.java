package com.ecommerce.shop.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shop.dao.FavorisDao;
import com.ecommerce.shop.model.Favoris;
import com.ecommerce.shop.model.User;
import com.ecommerce.shop.service.FavorisService;

@Service
public class FavorisServiceImpl implements FavorisService {
	@Autowired
	private FavorisDao favorisDao;

	@Override
	public List<Favoris> findAll() {
		return favorisDao.findAll();
	}

	@Override
	public Favoris save(Favoris favoris) {
		Favoris favoris1 = favorisDao.findByUserAndProduit(favoris.getUser(), favoris.getProduit());
		if (favoris1 != null)
			return null;
		return favorisDao.save(favoris);
	}

	@Override
	public List<Favoris> findAllByUser(User user) {
		return favorisDao.findAllByUser(user);

	}
    @Transactional
	@Override
	public void deleteFavoris(Favoris favoris) {
		// TODO Auto-generated method stub
		Favoris fav = favorisDao.getOne(favoris.getId());
		if (fav == null)
			return;
		favorisDao.delete(favoris);
	}

}
