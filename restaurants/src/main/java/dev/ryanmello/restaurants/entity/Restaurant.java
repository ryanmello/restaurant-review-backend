package dev.ryanmello.restaurants.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String type; // ex: italian, mexican, sandwich, breakfast
    private String address;
    private String cost; // annotated by $, $$, $$$, $$$$, or $$$$$
    private String image;

    // restaurant with no image defaults to image not found
    public Restaurant(String id, String name, String type, String address, String cost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.cost = cost;
        this.image = "https://static.vecteezy.com/system/resources/previews/005/337/799/original/icon-image-not-found-free-vector.jpg";
    }
}
