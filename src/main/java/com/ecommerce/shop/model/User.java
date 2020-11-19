package com.ecommerce.shop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String login;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String email;
	@Transient
	private String token;
	public String getToken() {
		return token;
	}

	public User(long id, String nom, String prenom, String login, Role role, String email, String token,
			String password, List<Favoris> favoris) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.role = role;
		this.email = email;
		this.token = token;
		this.password = password;
		this.favoris = favoris;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User(long id, String nom, String prenom, String login, String email, String token, String password,
			List<Favoris> favoris) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.email = email;
		this.token = token;
		this.password = password;
		this.favoris = favoris;
	}

	private String password;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Favoris> favoris = new ArrayList<>();;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String nom, String prenom, String login, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.email = email;
		this.password = password;
	}

	public User(long id, String nom, String prenom, String login, String email, String password,
			List<Favoris> favoris) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.email = email;
		this.password = password;
		this.favoris = favoris;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}

}
