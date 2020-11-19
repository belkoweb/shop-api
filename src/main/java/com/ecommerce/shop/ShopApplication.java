package com.ecommerce.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.shop.dao.FavorisDao;
import com.ecommerce.shop.dao.ProduitDao;
import com.ecommerce.shop.dao.UserDao;
import com.ecommerce.shop.model.Favoris;
import com.ecommerce.shop.model.Produit;
import com.ecommerce.shop.model.Role;
import com.ecommerce.shop.model.User;
@SpringBootApplication
public class ShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(UserDao userDao,ProduitDao produitDao,FavorisDao favorisDao ) {
		return (args) -> {
			///////////////////////////////////////////////////
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			User u1 = new User("yassir", "acaf", "yassirox", "yassir22@gmail.com", passwordEncoder.encode("1234"));
			u1.setRole(Role.USER);
			User u2 = new User("amadou", "soumana", "belkoweb", "bel23@gmail.com", passwordEncoder.encode("12345"));
			u2.setRole(Role.USER);
			userDao.save(u1);
			userDao.save(u2);
			///////////////////////////////////////////////////
			Produit p1 = new Produit("Corsair", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non cursus urna. Aenean id mi tempus", "images/1.jpg", 1200);
			Produit p2 = new Produit("Razer Headset", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non cursus urna. Aenean id mi tempus",  "images/2.jpg", 1400);
			Produit p3 = new Produit("Gaming Chair", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non cursus urna. Aenean id mi tempus", "images/3.jpg", 1200);
			Produit p4 = new Produit("Iphone", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non cursus urna. Aenean id mi tempus", "images/4.jpg", 1200);
			Produit p5 = new Produit("Asus Rog Tuf Screen", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non cursus urna. Aenean id mi tempus", "images/5.jpg", 1200);
			Produit p6 = new Produit("Asus Rog", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In non cursus urna. Aenean id mi tempus", "images/6.jpg", 1200);
			produitDao.save(p1);
			produitDao.save(p2);
			produitDao.save(p3);
			produitDao.save(p4);
			produitDao.save(p5);
			produitDao.save(p6);
			///////////////////////////////////////////////////
			java.util.List<User> users = userDao.findAll();
			//users.stream().forEach(t->System.out.println(t.getRole()));
			
		};
	}
}
