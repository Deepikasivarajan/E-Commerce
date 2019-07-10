package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.CategoryDTO;
import com.hcl.ecommerce.dto.ProductDTO;
import com.hcl.ecommerce.entity.ProductCategory;
import com.hcl.ecommerce.entity.Products;
import com.hcl.ecommerce.repository.CategoryRepository;
import com.hcl.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName(categoryDTO.getCategoryName());
		ProductCategory responseproductCategory = categoryRepository.save(productCategory);
		categoryDTO.setCategoryId(responseproductCategory.getProductCategoryId());
		return categoryDTO;
	}

	@Override
	public ProductCategory getByCategoryName(String categoryName) {
		ProductCategory responseproductCategory = categoryRepository.findByCategoryName(categoryName);
		return responseproductCategory;
	}

	@Override
	public ProductDTO addProducts(ProductDTO productDTO) {
		Products products = new Products();
		products.setPrice(productDTO.getPrice());
		products.setProductCategory(productDTO.getProductCategory());
		products.setProductName(productDTO.getProductName());
		Products responseProducts = productRepository.save(products);
		productDTO.setProductId(responseProducts.getProductId());
		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		ProductDTO productDTO = new ProductDTO();
		List<Products> responseProducts = productRepository.findAll();
		for (Products products : responseProducts) {
			productDTO.setProductName(products.getProductName());
			productDTO.setPrice(products.getPrice());
			listProductDTO.add(productDTO);
		}

		return listProductDTO;
	}

	@Override
	public List<ProductDTO> getByProductCategory(Long categoryId) {
		List<ProductDTO> listProductDTO = new ArrayList<ProductDTO>();
		ProductDTO productDTO = new ProductDTO();
		List<Products> responseProducts = productRepository.getByProductCategory(categoryId);
		for (Products products : responseProducts) {
			productDTO.setPrice(products.getPrice());
			productDTO.setProductName(products.getProductName());
			listProductDTO.add(productDTO);
		}
		return listProductDTO;
	}

}
