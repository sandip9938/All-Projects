package com.sp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a coupon in the system that can be used for discounts on orders.
 * This entity holds information about the coupon code, discount percentage,
 * validity dates, minimum order value, and the users who have used the coupon.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cupon {

    // Unique identifier for the coupon
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Unique coupon code (e.g., DISCOUNT10)
    private String code;

    // Discount percentage that the coupon offers (e.g., 10% off)
    private double discountPercentage;

    // Start date of the coupon's validity period
    private LocalDate validityStartDate;

    // End date of the coupon's validity period
    private LocalDate validityEndDate;

    // Minimum order value required to apply the coupon
    private double minimumOrderValues;

    // Indicates if the coupon is currently active or expired
    private boolean isActive = true;

    // Set of users who have used this coupon
    @ManyToMany(mappedBy = "usedCoupons")
    private Set<User> userByValues = new HashSet<>();
}
