package dev.ryanmello.restaurants.repository;

import dev.ryanmello.restaurants.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Integer> { }
