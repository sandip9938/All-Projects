package com.sp.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Home {

    private List<HomeCatagory> grid;

    private List<HomeCatagory> shopByCatagories;

    private List<HomeCatagory> electricCatagories;

    private List<HomeCatagory> deleteCatagories;

    private List<Deals> deals;
}
