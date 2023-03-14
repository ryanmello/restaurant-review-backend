package dev.ryanmello.restaurants.controller;

import dev.ryanmello.restaurants.entity.Restaurant;
import dev.ryanmello.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/restaurants")
@CrossOrigin("http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Restaurant>> getRestaurantById(@PathVariable String id){
        return new ResponseEntity<>(restaurantService.getRestaurantById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurantById(@PathVariable String id){
        restaurantService.deleteRestaurantById(id);
    }

//    @DeleteMapping
//    public void deleteAll(){
//        restaurantService.deleteAll();
//    }
}
