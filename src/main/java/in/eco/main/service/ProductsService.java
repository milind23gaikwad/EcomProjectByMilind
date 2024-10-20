package in.eco.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.eco.main.entities.Products;

public interface ProductsService {
	
    Page<Products> getAllProducts(Pageable pageable);
    
    Products getProductById(Long id);

    Products createProduct(Products products);
    
    Products updateProduct(Products products);
    
    void deleteProduct(Long id);
}