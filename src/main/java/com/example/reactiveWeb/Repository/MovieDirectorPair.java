package com.example.reactiveWeb.Repository;

import com.example.reactiveWeb.Model.Pair;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovieDirectorPair extends ReactiveCrudRepository<Pair, Integer> {

    public Flux<Pair> findAllByDirectorId(Integer director_id);
}
