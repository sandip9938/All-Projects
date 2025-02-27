package com.sp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents a product category in the system.
 * This entity holds information about a category's name, unique ID,
 * its parent category, and the hierarchical level in the category structure.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Catagory {

    // Unique identifier for the category
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Name of the category
    private String name;

    // Unique category identifier, must be unique in the system
    @org.jetbrains.annotations.NotNull
    @Column(unique = true)
    private String categoryId;

    // The parent category of this category, forming a hierarchical structure
    @ManyToOne
    private Catagory parentCategory;

    // The level of the category in the hierarchy (e.g., main category or subcategory)
    @NotNull
    private Integer level;
}
