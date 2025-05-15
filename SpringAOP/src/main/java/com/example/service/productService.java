package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ProductNotFoundException;
import com.example.model.product;
import com.example.repo.ProductRepository;

@Service
public class productService implements iProductService {

	@Autowired
	private ProductRepository Prepo;
	
	@Override
	public product save(product product) {
		// TODO Auto-generated method stub
		product p=Prepo.save(product);
		return p;
	}

	@Override
	public List<product> getAllProducts() {
		// TODO Auto-generated method stub
		List<product> p=Prepo.findAll();
		return p;
	}

	@Override
	public String DeleteProduct(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return Prepo.findById(id).map(ep->{
			Prepo.deleteById(id);
			return "Product with "+id+" deleted successfully";
		}).orElseThrow(()-> new ProductNotFoundException("Product not found"));
		
		 
		 
	}

	@Override
	public String UpdateProduct(product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return Prepo.findById(product.getId()).map(existingproduct->{
	    	existingproduct.setName(product.getName());
	    	existingproduct.setCost(product.getCost());
	    	Prepo.save(existingproduct);
	    	return "Product details updated successfully";
	    }).orElseThrow(()-> new ProductNotFoundException("Product not found with given ID"));
	}
	
	

}
