package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.UpdateProductDto;
import com.lti.entity.Product;
import com.lti.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService ps;

	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String addProduct(@RequestBody Product product) {
		String msg = ps.addProduct(product);
		return msg;
	}
	
	@GetMapping(value="/{productId}")
	public Product searchProduct(@PathVariable int productId) {
		return ps.findProduct(productId);
	}
	
	@GetMapping(value="/viewAll")
	public List<Product> viewProducts(){
		return ps.viewProducts();
	}
	
	@PutMapping("/update")
	public UpdateProductDto updateProduct(@RequestBody Product product) {
		return ps.updateProduct(product);
	}
	
}