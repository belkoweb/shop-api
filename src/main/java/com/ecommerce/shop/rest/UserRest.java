package com.ecommerce.shop.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shop.jwt.JwtTokenProvider;
import com.ecommerce.shop.model.Role;
import com.ecommerce.shop.model.User;
import com.ecommerce.shop.service.UserService;

@RestController
@RequestMapping("/shop-api/user")
public class UserRest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenProvider JwtTokenProvider;
	
	@GetMapping("/")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/login")
	public ResponseEntity<?> getUser(Principal principal){
	     if(principal == null){
	        return ResponseEntity.ok(principal);
	    }
	    UsernamePasswordAuthenticationToken authenticationToken =
	            (UsernamePasswordAuthenticationToken) principal;
	    User user = userService.findByLogin(authenticationToken.getName());
	    user.setToken(JwtTokenProvider.generateToken(authenticationToken));

	    return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		if (userService.findByLogin(user.getLogin()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		user.setRole(Role.USER);
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	

}
