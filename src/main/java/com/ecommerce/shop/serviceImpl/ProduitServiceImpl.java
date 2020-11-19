package com.ecommerce.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shop.dao.ProduitDao;
import com.ecommerce.shop.model.Produit;
import com.ecommerce.shop.service.ProduitService;
@Service
public class ProduitServiceImpl implements ProduitService {
     @Autowired
     private ProduitDao produitDao;
	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return produitDao.findAll();
	}

}
