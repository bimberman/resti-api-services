package com.cognixia.jump.springcloud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springcloud.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	 //List<User> findByUsername(String username);
	 
	 Optional<User> findByUsername(String username);
} 
