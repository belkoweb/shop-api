package com.ecommerce.shop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.model.Produit;
import com.ecommerce.shop.service.ProduitService;

@RestController
@RequestMapping("/shop-api/produit")
public class ProduitRest {
	@Autowired
	private ProduitService produitService;

	@GetMapping("/")
	public List<Produit> findAll() {
		return produitService.findAll();
	}
}
