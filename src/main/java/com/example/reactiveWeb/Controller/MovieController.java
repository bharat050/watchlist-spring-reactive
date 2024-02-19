package com.example.reactiveWeb.Controller;

import com.example.reactiveWeb.Model.Movie;
import com.example.reactiveWeb.Model.Pair;
import com.example.reactiveWeb.Service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    GlobalService globalService;
    @PostMapping("/add-movie")
    public Mono<Movie> addMovie(@RequestBody() Movie movie){
        return globalService.addMovie(movie);
    }

    @PostMapping("/add-movie-director-pair")
    public Mono<Pair> addMovieDirectorPair(@RequestParam Integer movie_id,
                                           @RequestParam Integer director_id){
        return globalService.addMovieDirectorPair(movie_id, director_id);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public Mono<Movie> getMovieByName(@PathVariable("name") String name){
        return globalService.getMovieByName(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public Flux<Movie> getMoviesByDirectorName(@PathVariable String director){
        return globalService.getMoviesByDirectorName(director);
    }

    @GetMapping("/get-all-movies")
    public Flux<Movie> getAllMovies(){
        return globalService.getAllMovies();
    }
}
