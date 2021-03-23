package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name="name")
	String name;
	
	@Column(name="address")
	String address;
	
	@Column(name="description")
	String description;
	
	@Column(name="reviews")
	ArrayList<String> reviews;
	
	@Column(name="rating")
	private Long rating;
	
	public Restaurant() {}

	public Restaurant(Long id, String name, String address, String description, ArrayList<String> reviews,
			Long rating) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.reviews = reviews;
		this.rating = rating;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Restaurant [Id=" + Id + ", name=" + name + ", address=" + address + ", description=" + description
				+ ", reviews=" + reviews + ", rating=" + rating + "]";
	}
}
