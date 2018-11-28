package com.topcinema;

import com.topcinema.domain.Movie;
import com.topcinema.repos.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MovieRepo movieRepo;

    @GetMapping
    public String greeting(Map<String, Object> model) {
        Iterable<Movie> movies = movieRepo.findAll();
        model.put("movies", movies);
        return "main";
    }
}
