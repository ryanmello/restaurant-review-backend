package dev.ryanmello.restaurants.service;

import dev.ryanmello.restaurants.entity.Restaurant;
import dev.ryanmello.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public void deleteRestaurantById(int id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant updateRestaurantById(int id, Restaurant newRestaurant) {
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(newRestaurant.getName());
                    restaurant.setType(newRestaurant.getType());
                    restaurant.setAddress(newRestaurant.getAddress());
                    restaurant.setCost(newRestaurant.getCost());
                    restaurant.setImage(newRestaurant.getImage());
                    restaurant.setDescription(newRestaurant.getDescription());
                    restaurant.setPhone(newRestaurant.getPhone());
                    restaurant.setWebsite(newRestaurant.getWebsite());
                    return restaurantRepository.save(restaurant);
                }).orElseThrow(() -> new IllegalArgumentException(String.valueOf(id)));
    }

//    @Override
//    public void deleteAll() {
//        restaurantRepository.deleteAll();
//    }
}
