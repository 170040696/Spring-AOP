package com.example.service;

import java.util.List;

import com.example.exception.ProductNotFoundException;
import com.example.model.product;

public interface iProductService {

	
	 product save(product product);
	
	 List<product> getAllProducts();
	
	String DeleteProduct(int id) throws ProductNotFoundException;
	
	String UpdateProduct(product product) throws ProductNotFoundException;
}
