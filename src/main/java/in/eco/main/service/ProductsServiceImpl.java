package in.eco.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.eco.main.entities.Products;
import in.eco.main.repositories.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Page<Products> getAllProducts(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }
      @Override
	  public Products getProductById(Long id) {
		  Optional <Products> optionalProducts=productsRepository.findById(id);
	    return optionalProducts.get();
	  }
	  @Override
	  public Products createProduct(Products products) {
	    return productsRepository.save(products);
	  }
	  
	  @Override
	  public Products updateProduct(Products products) {
	      Optional<Products> optionalProduct = productsRepository.findById(products.getId());
	      if (optionalProduct.isPresent()) {
	          Products existingProduct = optionalProduct.get();
	          if (products.getName() != null) {
	              existingProduct.setName(products.getName());
	          }
	          if (products.getPrice() != null) {
	              existingProduct.setPrice(products.getPrice());
	          }
	          if (products.getCategory() != null) {
	              existingProduct.setCategory(products.getCategory());
	          }
	          
	          return productsRepository.save(existingProduct);
	      } else {
	          throw new RuntimeException("Product not found");
	      }
	  }

	  @Override
	  public void deleteProduct(Long id) {
		  productsRepository.deleteById(id);

  
  
  }
}