package com.sp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a product in the system.
 * This entity holds information about the product title, description, pricing,
 * quantity, images, reviews, and its association with categories and sellers.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {

    // Unique identifier for the product
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Title or name of the product
    private String tittle;

    // Description of the product's price and other details
    private String descriptionPrice;

    // Maximum Retail Price (MRP) of the product
    private int mrpPrice;

    // Selling price of the product after any discounts
    private int sellingPrice;

    // Discount percentage applied to the product
    private int discountPercent;

    // Available quantity of the product in stock
    private int quantity;

    // Color of the product
    private String colour;

    // List of image URLs associated with the product
    @ElementCollection
    private List<String> images = new ArrayList<>();

    // Number of ratings the product has received
    private int numRating;

    // Category associated with the product (Many-to-Many relationship)
    @ManyToMany
    private Catagory catagory;

    // Seller who is offering the product (Many-to-One relationship)
    @ManyToOne
    private Seller seller;

    // Date and time when the product was created
    private LocalDateTime createdAt;

    // Available sizes for the product, stored as a string (e.g., "S, M, L")
    private String sizes;

    // List of reviews associated with the product
    private List<Review> reviews = new ArrayList<>();
}
