package com.movieapp.crudmovieapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_producer_name")
    private String producerName;


}
