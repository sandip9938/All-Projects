package com.sp.domain;

/**
 * Represents different roles assigned to users in the system.
 */
public enum UserRole {

    /**
     * Admin role - Has full access to manage the platform, users, and products.
     */
    ROLE_ADMIN,

    /**
     * Customer role - Can browse products, place orders, and leave reviews.
     */
    ROLE_CUSTOMER,

    /**
     * Seller role - Can list products, manage inventory, and fulfill orders.
     */
    ROLE_SELLER
}
