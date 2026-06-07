package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must be at least 5 characters long")
    private String street;

    @NotBlank
    @Size(min = 5, message = "building name must be at least 5 characters long")
    private String building;

    @NotBlank
    @Size(min = 2, message = "city name must be at least 2 characters long")
    private String city;

    @NotBlank
    @Size(min = 5, message = "state name must be at least 5 characters long")
    private String state;

    @NotBlank
    @Size(min = 2, message = "country name must be at least 2 characters long")
    private String country;

    @NotBlank
    @Size(min = 6, message = "pincode must be at least 6 characters long")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String street, String building, String city, String state, String country, String pincode) {
        this.street = street;
        this.building = building;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
}
