package com.movieapp.crudmovieapp.service;

import com.movieapp.crudmovieapp.model.Movie;
import com.movieapp.crudmovieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        return movieRepository.getReferenceById(id);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie saveMovie (Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteById (Long id) {
        movieRepository.deleteById(id);
    }
}
