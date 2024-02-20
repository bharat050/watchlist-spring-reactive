package com.example.reactiveWeb.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("pair")
@Builder
public class Pair {
    @Id
    private int pair_id;

    private int movie_id;
    private int director_id;
}
