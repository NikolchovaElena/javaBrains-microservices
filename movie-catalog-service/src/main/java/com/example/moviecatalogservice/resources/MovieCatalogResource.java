package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import com.example.moviecatalogservice.models.UserRating;
import com.example.moviecatalogservice.services.MovieInfoService;
import com.example.moviecatalogservice.services.UserRatingInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private MovieInfoService movieInfoService;
    @Autowired
    private UserRatingInfoService userRatingInfoService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        UserRating ratings = this.userRatingInfoService.getUserRating(userId);
        return ratings.getUserRating().stream()
                .map(rating -> this.movieInfoService.getCatalogItem(rating))
                .collect(Collectors.toList());
    }
}
