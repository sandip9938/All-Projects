package com.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
