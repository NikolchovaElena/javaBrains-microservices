package com.example.demo.resources;

import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId,4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 5),
                new Rating("1357", 6)
        );
        UserRating userRating =new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

}
