package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.product;

@Repository
public interface ProductRepository extends JpaRepository<product,Integer>{

	

}
