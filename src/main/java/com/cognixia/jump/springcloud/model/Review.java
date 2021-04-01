package com.cognixia.jump.springcloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Table(name="REVIEW")
@Entity
public class Review implements Serializable{

    private static final long serialVersionUID = 1L;
	
	//@Id --> primary key
	// @GeneratedValue --> use to set auto increment for this column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String comment;
	
	
	
	@Column(name="review")
	private Long review_id;
	
	@Column(name="RESTAURANTNAME")
	String restaurantName;
	
	@Column(name = "imageURL")
	private  String imageURL;

	@Column(name = "REVIEWDATE")
	private  String reviewDate;
	
	@Column(name = "REVIEWCOMMENT")
	private  String reviewComment;
	
	@Column(name = "REVIEWRATING")
	private  String reviewRating;
	
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@NotNull
	@Column(name="user_id", columnDefinition = "integer default 0")
	private Integer userId;
	
	@NotBlank
	private String username;
	
	private String userImageUrl;
	
	@NotNull
	@Column(name="restaurant_id", columnDefinition = "integer default 0")
	private Integer restaurantId;

	@NotNull
	@Column(columnDefinition = "double default 0")
	private Double rating;

	public Review() {
		this(-1L, "N/A", "N/A", new Date(), -1, "N/A", -1, 5.0);
	}
	public Review(Long id, @NotBlank String comment, String imageURL, Date creationDate, @NotNull Integer userId,
			@NotBlank String username, @NotNull Integer restaurantId, @NotNull Double rating) {
		super();
		this.id = id;
		this.comment = comment;
		this.imageURL = imageURL;
		this.creationDate = creationDate;
		this.userId = userId;
		this.username = username;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
		
	
}
