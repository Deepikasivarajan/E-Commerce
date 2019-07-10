package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.CategoryDTO;
import com.hcl.ecommerce.dto.ProductDTO;
import com.hcl.ecommerce.entity.ProductCategory;
import com.hcl.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/category")
	public String addCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryDTO category = productService.addCategory(categoryDTO);
		if (category.getCategoryId() != null) {
			return "success";
		} else {
			return "failed";
		}
	}

	@PostMapping("/products")
	public String addProducts(@RequestBody ProductDTO productDTO) {
		ProductCategory category = productService.getByCategoryName(productDTO.getCategoryName());
		productDTO.setProductCategory(category);
		ProductDTO responseproductDTO = productService.addProducts(productDTO);
		if (responseproductDTO.getProductId() != null) {

			return "success";
		} else {
			return "failed";
		}

	}

	@GetMapping("/productsList")
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		List<ProductDTO> products = productService.getAllProducts();
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}

	@GetMapping("/productsList/{categoryName}")
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable("categoryName") String categoryName) {
		ProductCategory category = productService.getByCategoryName(categoryName);
		List<ProductDTO> products = productService.getByProductCategory(category.getProductCategoryId());
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}
}
