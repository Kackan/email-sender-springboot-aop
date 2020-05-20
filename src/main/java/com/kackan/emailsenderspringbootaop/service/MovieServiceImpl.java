package com.kackan.emailsenderspringbootaop.service;
import com.kackan.emailsenderspringbootaop.model.Movie;
import com.kackan.emailsenderspringbootaop.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository repo;

    @Autowired
    public MovieServiceImpl(MovieRepository repo) {
        this.repo = repo;
        repo.save(new Movie(1l,"Titanic",1997,"kackanspring@gmail.com"));
        repo.save(new Movie(2l,"Never back down",2008,"kackanspring@gmail.com"));
        repo.save(new Movie(3l,"Catch me if you can",2002,"kackanspring@gmail.com"));
    }

    @Override
    public Optional<Movie> addMovie(Movie movie) {
        return Optional.of(repo.save(movie));
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return repo.findAll();
    }

    public Optional<Movie> getMovieById(Long id)
    {
        return repo.findById(id);
    }

}
