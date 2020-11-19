package com.ecommerce.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.shop.model.Produit;

public interface ProduitDao extends JpaRepository<Produit,Long>{

}
