package dev.ryanmello.restaurants.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "restaurants")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int id;
    private String name;
    private String type; // ex: italian, mexican, sandwich, breakfast
    private String address;
    private String cost; // annotated by $, $$, $$$, $$$$, or $$$$$
    private String image;
    private String description;
    private String phone;
    private String website;
    @DocumentReference
    private List<Review> reviewIds;

}
