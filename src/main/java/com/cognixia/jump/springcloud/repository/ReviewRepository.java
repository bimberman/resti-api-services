package com.cognixia.jump.springcloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.springcloud.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	// one of the methods listed in jpa, retrieve all the records/entities from a table
		List<Review> findAll();

}
