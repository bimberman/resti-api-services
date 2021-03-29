package com.cognixia.jump.springcloud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Table(name="USER")
@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public enum Role {
		ROLE_USER, ROLE_ADMIN
	}
	
	// @Id --> primary key
	// @GeneratedValue --> use to set auto increment for this column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// unique --> unique constraint
	// nullable --> not null constraint
	@Column(unique = true, nullable = false)
	private String username;
	
	// unique --> unique constraint
	// nullable --> not null constraint
	@Column(unique = false, nullable = false)
	private String password;
	
	@Column(name="EMAILADDRESS")
	String emailAddress;
	
	@Column(name = "imageURL")
	private  String imageURL;
	
	@Column(name= "FAVORITERESTAURANT")
	private String favoriteRestaurant;
	
	@Column(columnDefinition = "boolean default true")
	private boolean enabled;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Transient
	List<Review> reviews;
    
	
	public User() {
		this(-1L, "N/A", "N/A", "N/A", "N/A", "N/A", Role.ROLE_USER);
	}

	public User(Long id, String username, String password, String emailAddress, String imagePath, String favoriteRestaurant, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.imageURL = imageURL;
		this.favoriteRestaurant = favoriteRestaurant;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public String getFavoriteRestaurant() {
		return favoriteRestaurant;
	}

	public void setFavoriteRestaurant(String favoriteRestaurant) {
		this.favoriteRestaurant = favoriteRestaurant;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	

}
