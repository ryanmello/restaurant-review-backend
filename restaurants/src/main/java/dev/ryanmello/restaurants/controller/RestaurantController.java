package dev.ryanmello.restaurants.controller;

import dev.ryanmello.restaurants.entity.Restaurant;
import dev.ryanmello.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
@CrossOrigin("http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return new ResponseEntity<List<Restaurant>>(restaurantService.getAllRestaurants(), HttpStatus.OK);
    }



}
