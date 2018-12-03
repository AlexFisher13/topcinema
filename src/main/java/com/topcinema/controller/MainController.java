package com.topcinema.controller;

import com.topcinema.domain.Movie;
import com.topcinema.repos.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MovieRepo movieRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "home";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Movie> movies = movieRepo.findAll();
        model.put("movies", movies);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String title, @RequestParam String rating, Map<String, Object> model) {
        Movie movie = new Movie(title, rating);
        movieRepo.save(movie);
        Iterable<Movie> movies = movieRepo.findAll();
        model.put("movies", movies);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Movie> movies;

        if (filter != null && !filter.isEmpty()) {
            movies = movieRepo.findByTitle(filter);
        } else {
            movies = movieRepo.findAll();
        }

        model.put("movies", movies);
        return "main";
    }
}
