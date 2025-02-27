package com.sp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents an item in a shopping cart.
 * This entity holds information about the product, quantity, size,
 * and pricing details for each item in the cart.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CartItem {

    // Unique identifier for the cart item
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // The cart that this item belongs to, mapped as many-to-many relationship
    @ManyToMany
    @JsonIgnore  // Prevents infinite recursion during serialization (avoids circular references)
    private Cart cart;

    // The product associated with this cart item
    private Product product;

    // Size of the product (if applicable)
    private String size;

    // Quantity of the product in the cart, default is 1
    private Integer quantity = 1;

    // MRP (Maximum Retail Price) of the product
    private Integer mrpPrice;

    // Selling price of the product after any discounts
    private Integer sellingPrice;

    // User ID associated with the cart item (for tracking purposes)
    private Long userId;
}
