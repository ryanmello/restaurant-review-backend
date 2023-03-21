package dev.ryanmello.restaurants.service;

import dev.ryanmello.restaurants.entity.Restaurant;
import dev.ryanmello.restaurants.entity.Review;
import dev.ryanmello.restaurants.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, Integer id) {
        /* create a review object and insert the review into the review repository */
        Review review = reviewRepository.insert(new Review(reviewBody));

        /*  update the restaurant class
            where the given id matches the id of a restaurant object and
            apply the review object to the array of review ids in the restaurant class */
        mongoTemplate.update(Restaurant.class)
                .matching(Criteria.where("id").is(id))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
