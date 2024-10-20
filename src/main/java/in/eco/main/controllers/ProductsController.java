package in.eco.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.eco.main.entities.Products;
import in.eco.main.service.ProductsService;
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public Page<Products> getAllProducts(@RequestParam(defaultValue = "0") int page, 
                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productsService.getAllProducts(pageable);
    }
  
  @GetMapping("/{id}")
  public ResponseEntity<Products> getProductById(@PathVariable Long id) { //GET product by Id
    return ResponseEntity.ok(productsService.getProductById(id));
  }
  
  @PostMapping
  public ResponseEntity<Products> createProduct(@RequestBody Products products) { //POST - create a new product
    return ResponseEntity.ok(productsService.createProduct(products));
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products products) { //PUT - update product by id
    return ResponseEntity.ok(productsService.updateProduct(products));
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) { //DELETE - Delete product by id
    productsService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }
}
