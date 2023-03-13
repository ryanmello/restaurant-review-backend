package dev.ryanmello.restaurants.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    private Integer id;
    private String name;
    private String type; // ex: italian, mexican, sandwich, breakfast
    private String address;
    private String cost; // annotated by $, $$, $$$, $$$$, or $$$$$
    private String image;
}
