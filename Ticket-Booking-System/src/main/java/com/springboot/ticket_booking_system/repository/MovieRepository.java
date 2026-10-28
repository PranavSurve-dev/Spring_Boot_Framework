package com.springboot.ticket_booking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ticket_booking_system.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	List<Movie> findByTitle(String title);
	
	List<Movie> findByGenre(String genre);

	
}