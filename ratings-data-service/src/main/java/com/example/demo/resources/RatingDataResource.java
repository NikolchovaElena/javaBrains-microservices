package com.example.demo.resources;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;
import com.example.demo.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {
    @Autowired
    private RatingRepository repo;

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId) {
        List<Rating> ratings = this.repo.findAll();
        return new UserRating(userId, ratings);
    }

}
