package dev.ryanmello.restaurants.service;

import dev.ryanmello.restaurants.entity.Restaurant;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    Optional<Restaurant> getRestaurantById(String id);
    Restaurant addRestaurant(Restaurant restaurant);
    void deleteRestaurantById(String id);
    //void deleteAll();
}
