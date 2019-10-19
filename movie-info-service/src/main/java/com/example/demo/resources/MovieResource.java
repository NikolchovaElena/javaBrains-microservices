package com.example.demo.resources;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {

        MovieSummary movieSummary = this.restTemplate
                .getForObject("http://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + this.apiKey, MovieSummary.class);

        return new Movie(movieId, movieSummary.getTitle(),movieSummary.getOverview());
    }

}
