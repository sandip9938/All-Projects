package com.sp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a shopping cart in the e-commerce system.
 * This entity holds information about the cart items, total price, user details,
 * and any applicable discounts or coupon codes.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cart {

    // Unique identifier for the cart
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // The user associated with the cart
    private User user;

    // Set of CartItems associated with this cart
    @ManyToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItem = new HashSet<>();

    // Total selling price of all items in the cart (after discounts)
    private double tatalSellingPrice;

    // Total number of items in the cart
    private int totalItem;

    // Total MRP (Maximum Retail Price) of all items in the cart
    private int totalMrpPrice;

    // Discount applied to the cart, if any
    private double discount;

    // Coupon code used for discounts, if applicable
    private String cuponCode;
}
