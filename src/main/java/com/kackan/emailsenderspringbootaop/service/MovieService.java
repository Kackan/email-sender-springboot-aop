package com.kackan.emailsenderspringbootaop.service;

import com.kackan.emailsenderspringbootaop.model.Movie;

import java.util.Optional;

public interface MovieService {

    Optional<Movie> addMovie(Movie movie);
    Iterable<Movie> getAllMovies();
    Optional<Movie> getMovieById(Long id);
}
