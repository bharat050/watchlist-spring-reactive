package com.example.reactiveWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("director")
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    private int director_id;
    private String name;
    private int number_of_movies;
    private double imdb_rating;
}
