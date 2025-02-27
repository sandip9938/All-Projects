package com.sp.entity;

import lombok.Data;

/**
 * Represents the bank details of a user or business.
 */
@Data
public class BankDetails {

    /**
     * The bank account number.
     */
    private String accountNumber;

    /**
     * The name of the account holder.
     */
    private String accountHolderName;

    /**
     * The IFSC code of the bank branch.
     */
    private String ifscCode;
}
