package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository repo;
	
	public List<Restaurant> getAllRestaurants() {
		
		return repo.findAll();
	}
	
	public Restaurant getRestaurantById(long id) throws ResourceNotFoundException {
		
		Optional<Restaurant> found = repo.findById(id);
		
		if(!found.isPresent()) {
			throw new ResourceNotFoundException("Restaurant with id = " + id + " could not be found.");
		}
		
		return found.get();
	}


	

}