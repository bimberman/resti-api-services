package com.cognixia.jump.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognixia.jump.model.Restaurant;

@Repository
@EntityScan(basePackages = {"com.cognixia.jump.model"})
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	List<Restaurant> findAll();
	Optional<Restaurant> findById(Long id);
	List<Restaurant> findByName(String name);
	List<Restaurant> findByAddress(String address);
	List<Restaurant> findByDescription(String description);
}