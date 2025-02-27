package com.sp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a review given by a user for a product.
 * This entity holds the review text, rating, product images,
 * and the association with the user and product being reviewed.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Review {

    // Unique identifier for the review
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // The review text provided by the user
    @Column(nullable = false)
    private String reviewText;

    // Rating given by the user, typically between 1 and 5
    @Column(nullable = false)
    private double rating;

    // List of product images uploaded along with the review
    @ElementCollection
    private List<String> productImages;

    // The product being reviewed, many reviews can belong to a single product
    @JsonIgnore  // Prevents the circular reference during serialization
    @ManyToOne
    @JoinColumn(name = "product_Id", nullable = false)
    private Product product;

    // The user who submitted the review
    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    // Timestamp of when the review was created
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
