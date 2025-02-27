package com.sp.domain;

/**
 * Represents the various states an account can have in the system.
 */
public enum AccountStatus {

    /**
     * Account is pending verification, usually after registration or email confirmation.
     */
    PENDING_VERIFICATION,

    /**
     * Account is fully active and can perform all operations.
     */
    ACTIVE,

    /**
     * Account is temporarily suspended, possibly due to policy violations or security reasons.
     */
    SUSPENDED,

    /**
     * Account has been deactivated by the user or an admin, but may be reactivated later.
     */
    DEACTIVATED,

    /**
     * Account has been banned due to serious violations and cannot be reactivated.
     */
    BANNED,

    /**
     * Account has been permanently closed and is no longer accessible.
     */
    CLOSED
}
