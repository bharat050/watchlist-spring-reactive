package com.example.reactiveWeb.Repository;

import com.example.reactiveWeb.Model.Pair;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDirectorPair extends ReactiveCrudRepository<Pair, Integer> {

}
