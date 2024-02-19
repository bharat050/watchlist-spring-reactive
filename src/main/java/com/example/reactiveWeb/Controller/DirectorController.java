package com.example.reactiveWeb.Controller;

import com.example.reactiveWeb.Model.Director;
import com.example.reactiveWeb.Model.Movie;
import com.example.reactiveWeb.Service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    GlobalService globalService;
    @PostMapping("/add-director")
    public Mono<Director> addDirector(@RequestBody()Director director){
        return globalService.addDirector(director);
    }

    @GetMapping("get-director-by-name/{name}")
    public Mono<Director> getDirectorByName(@PathVariable("name") String name){
        return globalService.getDirectorByName(name);
    }

    @DeleteMapping("/delete-director-by-name")
    public Mono<Director> deleteDirectorByName(@RequestParam String name){
        return globalService.deleteDirectorByName(name);
    }

    @DeleteMapping("delete-all-directors")
    public Mono<Void> deleteAllDirectors(){
        return globalService.deleteAllDirectors();
    }
}
