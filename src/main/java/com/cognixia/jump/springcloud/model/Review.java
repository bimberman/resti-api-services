package com.cognixia.jump.springcloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="REVIEW")
@Entity
public class Review implements Serializable{

    private static final long serialVersionUID = 1L;
	
	//@Id --> primary key
	// @GeneratedValue --> use to set auto increment for this column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long restaurant_id;
	
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
	
	
	public Review() {
		this(-1L, -1L, "N/A", "N/A", "N/A", "N/A", "N/A");
	}


	public Review(Long restaurant_id, Long review_id, String restaurantName, String imageURL, String reviewDate,
			String reviewComment, String reviewRating) {
		super();
		this.restaurant_id = restaurant_id;
		this.review_id = review_id;
		this.restaurantName = restaurantName;
		this.imageURL = imageURL;
		this.reviewDate = reviewDate;
		this.reviewComment = reviewComment;
		this.reviewRating = reviewRating;
	}


	public Long getRestaurant_id() {
		return restaurant_id;
	}


	public void setRestaurant_id(Long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}


	public Long getReview_id() {
		return review_id;
	}


	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public String getReviewDate() {
		return reviewDate;
	}


	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}


	public String getReviewComment() {
		return reviewComment;
	}


	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}


	public String getReviewRating() {
		return reviewRating;
	}


	public void setReviewRating(String reviewRating) {
		this.reviewRating = reviewRating;
	}

	
}
