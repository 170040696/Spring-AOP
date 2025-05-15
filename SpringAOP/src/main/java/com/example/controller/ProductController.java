package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ProductNotFoundException;
import com.example.model.product;
import com.example.service.iProductService;

@RestController
public class ProductController {
	
	@Autowired
	private iProductService iproductservice;
	
	@PostMapping("/registerproduct")
	public ResponseEntity<product> RegisterProduct(@RequestBody product p)
	{
		product product=iproductservice.save(p);
		return new ResponseEntity<product>(product,HttpStatus.CREATED);
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<List<product>> retriveAllProducts(){
		return new ResponseEntity<List<product>>(iproductservice.getAllProducts(),HttpStatus.OK);
	}
	
	@PutMapping("/updateproduct")
	public ResponseEntity<String> UpdateProduct(@RequestBody product p) {
		return new ResponseEntity<String>(iproductservice.UpdateProduct(p), HttpStatus.OK);
		}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> DeleteProduct(@PathVariable("id") int id)  {
		return new ResponseEntity<String>(iproductservice.DeleteProduct(id),HttpStatus.OK);
	}
	
	

}
