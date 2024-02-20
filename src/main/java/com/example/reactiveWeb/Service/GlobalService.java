package com.example.reactiveWeb.Service;

import com.example.reactiveWeb.Model.Director;
import com.example.reactiveWeb.Model.Movie;
import com.example.reactiveWeb.Model.Pair;
import com.example.reactiveWeb.Repository.DirectorRepository;
import com.example.reactiveWeb.Repository.MovieDirectorPair;
import com.example.reactiveWeb.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GlobalService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    MovieDirectorPair movieDirectorPair;
    public Mono<Movie> addMovie(Movie movie) {
        return movieRepository.save(Movie.builder()
                .name(movie.getName())
                .duration_in_minutes(movie.getDuration_in_minutes())
                .imdb_rating(movie.getImdb_rating())
                .build());
    }

    public Mono<Director> addDirector(Director director) {
        return directorRepository.save(Director.builder()
                .name(director.getName())
                .number_of_movies(director.getNumber_of_movies())
                .imdb_rating(director.getImdb_rating()).build());
    }

    public Mono<Pair> addMovieDirectorPair(Integer movieId, Integer directorId) {
        return movieDirectorPair.save(Pair.builder()
                .movie_id(movieId).director_id(directorId).build());
    }

    public Mono<Movie> getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public Mono<Director> getDirectorByName(String name) {
        return directorRepository.findByName(name);
    }

    public Flux<Movie> getMoviesByDirectorName(String director) {
        Mono<Integer> id = directorRepository.findByName(director)
                .map(Director::getDirector_id);

//        Flux<Integer> movieList = movieDirectorPair.findAllByDirectorId(id)

//        directorRepository.findByName(directorName)
//                .flatMapMany(director -> pairRepository.findByDirectorId(director.getId()))
//                .flatMap(pair -> movieRepository.findById(pair.getMovieId()));
        return null;
    }

    public Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Mono<Director> deleteDirectorByName(String name) {
        return directorRepository.deleteByName(name);
    }

    public Mono<Void> deleteAllDirectors() {
        directorRepository.deleteAll();
        return null;
    }

    public Mono<Director> updateDirectorRatingById(Integer id, Double rating) {
        return directorRepository.findById(id)
                .flatMap(director -> directorRepository.save(Director.builder()
                        .director_id(director.getDirector_id())
                        .name(director.getName())
                        .imdb_rating(rating)
                        .number_of_movies(director.getNumber_of_movies()).build()));
    }
}
