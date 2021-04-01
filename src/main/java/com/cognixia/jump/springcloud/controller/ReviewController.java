package com.cognixia.jump.springcloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/reviews/{id}")
	public Review getReview(@PathVariable long id) {
		
		Optional<Review> reviewOpt = review.findById(id);
		
		if(reviewOpt.isPresent()) {
			return reviewOpt.get();
		}
		
		return new Review();
	}
	
	@PostMapping("/add/review")
	public void addUser(@RequestBody Review newReview) {
		
		newReview.setId(-1L);
		
		Review added = review.save(newReview); // save() does an insert or update (depends on id passed)
		
		System.out.println("Added: " + added);
		
	}
	
	@DeleteMapping("/delete/review/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable long id) {
		
		Optional<Review> found = review.findById(id);
		
		if(found.isPresent()) {
			
			review.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted review with id = " + id);	
		}
		else {
			return ResponseEntity.status(400)
					.header("review id", id + "")
					.body("Review with id = " + id + " not found");
		}
			
	}

}
