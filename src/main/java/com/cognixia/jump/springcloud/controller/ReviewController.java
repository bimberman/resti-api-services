package com.cognixia.jump.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Review;
import com.cognixia.jump.springcloud.repository.ReviewRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReviewController {
	
	@Autowired
    private ReviewRepository review;
	
	@GetMapping("/reviews")
	public List<Review> getAllReviews() {
		
		return review.findAll();
	}

}
