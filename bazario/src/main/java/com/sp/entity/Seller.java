package com.sp.entity;

import com.sp.domain.AccountStatus;
import com.sp.domain.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents a seller in the e-commerce system.
 * This entity holds information about the seller’s contact details, business information,
 * bank details, GSTIN, and account verification status.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Seller {

    // Unique identifier for the seller
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Name of the seller (business or individual)
    private String sellerName;

    // Mobile number of the seller
    private String mobile;

    // Email address of the seller, must be unique and non-null
    @Column(unique = true, nullable = false)
    private String email;

    // Password for the seller's account
    private String password;

    // Business details associated with the seller
    @Embedded
    private BuisnessDetails buisnessDetails = new BuisnessDetails();

    // Bank details associated with the seller
    @Embedded
    private BankDetails bankDetails = new BankDetails();

    // Address for product pickup
    private Address pickupAddress = new Address();

    // GSTIN (Goods and Services Tax Identification Number) for the seller
    private String GSTIN;

    // Role of the user, default is ROLE_SELLER
    private UserRole role = UserRole.ROLE_SELLER;

    // Indicates if the seller's email has been verified
    private boolean isEmailVerified = false;

    // The status of the seller's account (default is PENDING_VERIFICATION)
    private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;
}
