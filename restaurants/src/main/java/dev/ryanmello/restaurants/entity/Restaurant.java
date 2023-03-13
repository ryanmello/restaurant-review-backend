package dev.ryanmello.restaurants.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
public class Restaurant {
    private String name;
    private String type; // ex: italian, mexican, sandwich, breakfast
    private String address;
    private String cost; // annotated by $, $$, $$$, $$$$, or $$$$$
    private String image;
}
