package com.example.reactiveWeb.Repository;

import com.example.reactiveWeb.Model.Director;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DirectorRepository extends ReactiveCrudRepository<Director, Integer> {

    public Mono<Director> findByName(String name);

    public Mono<Director> deleteByName(String name);
}
