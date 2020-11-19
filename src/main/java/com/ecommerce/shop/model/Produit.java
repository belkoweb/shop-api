package com.ecommerce.shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String libelle;
	private String description;
	private String image;
	private float prix;
	@OneToMany(mappedBy = "produit")
	@JsonIgnore
	private List<Favoris> favoris = new ArrayList<>();
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit( String libelle, String description, String image, float prix) {
		this.libelle = libelle;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}
	public Produit(long id, String libelle, String description, String image, float prix, List<Favoris> favoris) {
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.image = image;
		this.prix = prix;
		this.favoris = favoris;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public List<Favoris> getFavoris() {
		return favoris;
	}
	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}
	 
	
}
