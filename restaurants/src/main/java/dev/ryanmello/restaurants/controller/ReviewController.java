package dev.ryanmello.restaurants.controller;

import dev.ryanmello.restaurants.entity.Review;
import dev.ryanmello.restaurants.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin("https://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//    public ResponseEntity<Review> createReview(@RequestBody Map<String, Integer> payload){
//        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("id")), HttpStatus.OK);
//    }
}
