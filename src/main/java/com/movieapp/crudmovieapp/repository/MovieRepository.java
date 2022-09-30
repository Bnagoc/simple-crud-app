package com.movieapp.crudmovieapp.repository;

import com.movieapp.crudmovieapp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
