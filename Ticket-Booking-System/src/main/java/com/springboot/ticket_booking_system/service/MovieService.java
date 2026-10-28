package com.springboot.ticket_booking_system.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.ticket_booking_system.dto.MovieRequestDTO;
import com.springboot.ticket_booking_system.dto.MovieResponseDTO;
import com.springboot.ticket_booking_system.entity.Movie;
import com.springboot.ticket_booking_system.enums.MovieStatus;
import com.springboot.ticket_booking_system.exception.ResourceNotFoundException;
import com.springboot.ticket_booking_system.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	private final ModelMapper modelMapper;

	public MovieResponseDTO createMovie(MovieRequestDTO movieRequestDTO) {
		Movie movie = modelMapper.map(movieRequestDTO, Movie.class);
		movie.setStatus(MovieStatus.ACTIVE);
		Movie savedMovie = movieRepository.save(movie);
		return modelMapper.map(savedMovie, MovieResponseDTO.class);
	}

	public List<MovieResponseDTO> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		List<MovieResponseDTO> movieResponseDTOs = new ArrayList<>();
		for (Movie movie : movies) {
			movieResponseDTOs.add(modelMapper.map(movie, MovieResponseDTO.class));
		}
		return movieResponseDTOs;
	}

	public List<MovieResponseDTO> findByTitle(String title) {
		List<Movie> movies = movieRepository.findByTitle(title);
		List<MovieResponseDTO> movieResponseDtos = new ArrayList<>();
		for (Movie movie : movies) {
			movieResponseDtos.add(modelMapper.map(movie, MovieResponseDTO.class));
		}
		return movieResponseDtos;
	}

	public MovieResponseDTO getMovieById(Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie id" + id + "iS not found"));
		return modelMapper.map(movie, MovieResponseDTO.class);
	}

	public MovieResponseDTO updateMovieById(Long id, MovieRequestDTO movieRequestDTO) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie id " + id + " not found"));
		movie.setDescription(movieRequestDTO.getDescription());
		movie.setCertificate(movieRequestDTO.getCertificate());
		movie.setDuration(movieRequestDTO.getDuration());
		movie.setGenre(movieRequestDTO.getGenre());
		movie.setLanguage(movieRequestDTO.getLanguage());
		movie.setReleaseDate(movieRequestDTO.getReleaseDate());
		movie.setTitle(movieRequestDTO.getTitle());
		Movie updateMovie = movieRepository.save(movie);
		return modelMapper.map(updateMovie, MovieResponseDTO.class);
	}

}