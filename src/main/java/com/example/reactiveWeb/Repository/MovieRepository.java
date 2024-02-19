package com.example.reactiveWeb.Repository;

import com.example.reactiveWeb.Model.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie, Integer> {

    public Mono<Movie> findByName(String name);
}
