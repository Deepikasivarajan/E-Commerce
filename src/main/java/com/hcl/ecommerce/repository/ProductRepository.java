package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.ecommerce.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {
	@Query("Select p from Products p where p.productCategory.productCategoryId=?1")
	List<Products> getByProductCategory(Long categoryId);

}
