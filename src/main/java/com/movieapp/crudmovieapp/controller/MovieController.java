package com.movieapp.crudmovieapp.controller;

import com.movieapp.crudmovieapp.model.Movie;
import com.movieapp.crudmovieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String findAll(Model model){
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "movie-list";
    }

    @GetMapping("/movie-add")
    public String addMovieForm(Movie movie){
        return "movie-add";
    }

    @PostMapping("/movie-add")
    public String addMovie(Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/movie-update")
    public String updateMovieForm(Movie movie){
        return "movie-update";
    }
}
