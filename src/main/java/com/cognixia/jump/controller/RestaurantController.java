package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.repository.RestaurantRepository;

@RequestMapping("/api")
@CrossOrigin
@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantRepository service;
	
	@CrossOrigin
	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurants() {
		
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/restaurants/{id}")
	public Restaurant getRestaurant(@PathVariable long id) {
		
		Optional<Restaurant> restaurantOpt = service.findById(id);
		
		if(restaurantOpt.isPresent()) {
			return restaurantOpt.get();
		}
		
		return new Restaurant();
	}
	
	@CrossOrigin
	@PostMapping("/add/restaurant")
	public Restaurant addRestaurant(@RequestBody Restaurant newRestaurant) {
		
		return service.save(newRestaurant);	
	}
	
	@CrossOrigin
	@PutMapping("/update/restaurant")
	public @ResponseBody String updateRestaurant(@RequestBody Restaurant updateRestaurant) {
		
		Optional<Restaurant> found = service.findById(updateRestaurant.getId());
		
		if (found.isPresent()) {
			service.save(updateRestaurant);
			return "Saved: " + updateRestaurant.toString();
		}
		else {
			return "Could not update restaurant, the id = " + updateRestaurant.getId() + " doesn't exist";
		}
		
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/restaurant/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable long id) {
		
		Optional<Restaurant> found = service.findById(id);
		
		if(found.isPresent()) {
			
			service.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted restaurant with id = " + id);	
		}
		else {
			return ResponseEntity.status(400)
					.header("restaurant id", id + "")
					.body("Restaurant with id = " + id + " not found");
		}		
	}
}










