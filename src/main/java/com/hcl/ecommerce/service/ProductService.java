package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.CategoryDTO;
import com.hcl.ecommerce.dto.ProductDTO;
import com.hcl.ecommerce.entity.ProductCategory;

public interface ProductService {

	CategoryDTO addCategory(CategoryDTO categoryDTO);

	ProductCategory getByCategoryName(String categoeryName);

	ProductDTO addProducts(ProductDTO productDTO);

	List<ProductDTO> getAllProducts();

	List<ProductDTO> getByProductCategory(Long categoryId);

}
