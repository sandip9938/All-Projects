package com.sp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the business details associated with a vendor or company.
 * This class contains information such as the business name, contact details,
 * and logo/banner for a company or vendor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuisnessDetails {

    // Name of the business or company
    private String businessName;

    // Email address of the business or company
    private String businessEmail;

    // Mobile number for contacting the business or company
    private String businessMobile;

    // Physical address of the business or company
    private String businessAddress;

    // Path or URL to the logo image of the business
    private String logo;

    // Path or URL to the banner image of the business
    private String banner;
}
