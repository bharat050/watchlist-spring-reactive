package com.example.reactiveWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("movie")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    private int movie_id;
    private String name;
    private int duration_in_minutes;
    private double imdb_rating;
}
