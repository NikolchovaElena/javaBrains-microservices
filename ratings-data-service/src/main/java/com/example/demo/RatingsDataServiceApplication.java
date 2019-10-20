package com.example.demo;

import com.example.demo.models.Rating;
import com.example.demo.repositories.RatingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RatingsDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.demo.RatingsDataServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(RatingRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Rating("150689", 4));
                repo.save(new Rating("151460", 5));
                repo.save(new Rating("141460", 6));
            }
        };
    }
}