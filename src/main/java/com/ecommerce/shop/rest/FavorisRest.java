package com.ecommerce.shop.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.model.Favoris;
import com.ecommerce.shop.model.User;
import com.ecommerce.shop.service.FavorisService;

@RestController
@RequestMapping("/shop-api/favoris")
public class FavorisRest {
	@Autowired
	private FavorisService favorisService;
	@PostMapping("/delete")
    public void deleteFavoris(@RequestBody Favoris favoris) {
		favorisService.deleteFavoris(favoris);
	}

	@PostMapping("/findAll")
	public List<Favoris> findAllByUser(@RequestBody User user) {
		return favorisService.findAllByUser(user);
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody Favoris favoris) {
		Favoris fav = favorisService.save(favoris);
		if (fav != null) {
			return new ResponseEntity<>(fav, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@GetMapping("/")
	public List<Favoris> findAll() {
		return favorisService.findAll();
	}
}
