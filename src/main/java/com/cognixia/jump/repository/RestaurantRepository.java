package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	List<Restaurant> findByname(String name);
	List<Restaurant> findByaddress(String address);
	List<Restaurant> findBydescription(String description);
}