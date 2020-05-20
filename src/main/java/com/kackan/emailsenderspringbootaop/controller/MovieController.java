package com.kackan.emailsenderspringbootaop.controller;
import com.kackan.emailsenderspringbootaop.aspect.OwnMailSenderAOP;
import com.kackan.emailsenderspringbootaop.model.Movie;
import com.kackan.emailsenderspringbootaop.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    @OwnMailSenderAOP
    public ResponseEntity<EntityModel<Movie>> addMovie(@Validated @RequestBody Movie movie)
    {
        Link link=linkTo(MovieController.class).withSelfRel();
        EntityModel<Movie> movieEntity=new EntityModel<>(movie,link);
        return service.addMovie(movie).map(m->new ResponseEntity<>(movieEntity,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @GetMapping()
    public ResponseEntity<CollectionModel<Movie>> getAll()
    {
        Iterable<Movie> allMovies = service.getAllMovies();
        allMovies.forEach(m->m.addIf(!m.hasLinks(),()->linkTo(MovieController.class).slash(m.getId()).withSelfRel()));
        Link link=linkTo(MovieController.class).withSelfRel();

        CollectionModel<Movie>movieCollectionModel=new CollectionModel<>(allMovies,link);
        return new ResponseEntity<>(movieCollectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Movie>> getMovie(@PathVariable Long id)
    {
        Optional<Movie> movieById = service.getMovieById(id);

        if(movieById.isPresent())
        {
            Movie movie=movieById.get();
            Link link=linkTo(MovieController.class).slash(id).withSelfRel();
            movie.addIf(!movie.hasLinks(),()->link);

            EntityModel entityMovie=new EntityModel<>(movie);
            return new ResponseEntity<>(entityMovie,HttpStatus.OK);
        }else
        {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
