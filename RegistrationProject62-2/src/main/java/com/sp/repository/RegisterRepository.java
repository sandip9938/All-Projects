package com.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.entity.RegisterPerson;

public interface RegisterRepository extends JpaRepository<RegisterPerson, Integer>{

}
