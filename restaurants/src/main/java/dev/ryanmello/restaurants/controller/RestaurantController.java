package dev.ryanmello.restaurants.controller;

import dev.ryanmello.restaurants.entity.Restaurant;
import dev.ryanmello.restaurants.service.RestaurantSequenceService;
import dev.ryanmello.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static dev.ryanmello.restaurants.entity.Restaurant.SEQUENCE_NAME;

@RestController
@RequestMapping("api/v1/restaurants")
@CrossOrigin("http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantSequenceService restaurantSequenceService;

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        restaurant.setId(restaurantSequenceService.getSequenceNumber(SEQUENCE_NAME));
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Restaurant>> getRestaurantById(@PathVariable int id){
        return new ResponseEntity<>(restaurantService.getRestaurantById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurantById(@PathVariable int id){
        restaurantService.deleteRestaurantById(id);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurantById(@PathVariable int id, @RequestBody Restaurant newRestaurant){
        return restaurantService.updateRestaurantById(id, newRestaurant);
    }

//    @DeleteMapping
//    public void deleteAll(){
//        restaurantService.deleteAll();
//    }
}
