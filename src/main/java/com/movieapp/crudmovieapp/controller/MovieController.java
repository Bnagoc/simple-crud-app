package com.movieapp.crudmovieapp.controller;

import com.movieapp.crudmovieapp.model.Movie;
import com.movieapp.crudmovieapp.service.MovieService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String findAll(@NotNull Model model){
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

    @GetMapping("/movie-delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id){
        movieService.deleteById(id);
        return "redirect:/movies";
    }

    @GetMapping("/movie-update/{id}")
    public String updateMovieForm(@PathVariable("id") Long id, @NotNull Model model){
        Movie movie = movieService.findById(id);
        model.addAttribute("movie", movie);
        return "/movie-update";
    }

    @PostMapping("/movie-update")
    public String updateMovie(Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/movies";
    }
}
