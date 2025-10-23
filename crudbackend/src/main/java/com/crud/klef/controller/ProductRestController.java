package com.crud.klef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crud.klef.entity.Product;
import com.crud.klef.service.productservice;

@CrossOrigin("*")
@RequestMapping("/products")
@RestController
public class ProductRestController {

	@Autowired
	private productservice pro;

	@PostMapping("/add")
	public Product createProduct(@RequestBody Product product) {
		return pro.saveProduct(product);
	}

	@GetMapping("/")
	public List<Product> getproduct() {
		return pro.getproduct();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return pro.getProductById(id);
	}

	@GetMapping("/count")
	public Long procount() {
		return pro.count();
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) {
		pro.deleteProduct(id);

		return "Product with id " + id + " deleted successfully.";
	}

	@PutMapping(value = "/{id}")
	public Product updateProduct(
			@PathVariable Long id,
			@RequestBody Product updatedProduct) throws Exception {
		return pro.updateProduct(id, updatedProduct);
	}

}
