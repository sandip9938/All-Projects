package com.sp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sp.domain.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a user in the system.
 * This entity holds information about the user's personal details,
 * role, addresses, and any coupons they have used.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    // Unique identifier for the user
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // User password (write-only access to protect from serialization)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    // Email address of the user
    private String email;

    // Full name of the user
    private String fullName;

    // Mobile number of the user
    private Long phNo;

    // Role of the user (default is ROLE_CUSTOMER)
    private UserRole role = UserRole.ROLE_CUSTOMER;

    // Set of addresses associated with the user (One-to-Many relationship)
    @OneToMany
    private Set<Address> addresses = new HashSet<>();

    // Set of coupons used by the user (Many-to-Many relationship)
    @ManyToMany
    @JsonIgnore  // Prevents the coupons from being serialized into the response
    private Set<Cupon> usedCoupons = new HashSet<>();
}
