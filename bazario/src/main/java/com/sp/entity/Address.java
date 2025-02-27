package com.sp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents an address entity used for storing user or business addresses.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address {

    /**
     * Unique identifier for the address.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the person or business associated with the address.
     */
    private String name;

    /**
     * Locality or neighborhood of the address.
     */
    private String locality;

    /**
     * Detailed street address.
     */
    private String address;

    /**
     * City where the address is located.
     */
    private String city;

    /**
     * State where the address is located.
     */
    private String state;

    /**
     * Postal code or ZIP code of the address.
     */
    private String pincode;

    /**
     * Contact mobile number associated with the address.
     */
    private String mobile;
}
