package com.sp.repository;

import com.sp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BazarioRepository extends JpaRepository<User, Long> {

}

