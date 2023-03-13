package dev.ryanmello.restaurants.repository;

import dev.ryanmello.restaurants.entity.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, ObjectId> { }
