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

import in.eco.main.entities.Category;
import in.eco.main.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, 
                                           @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryService.getAllCategories(pageable);
    }
  
  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) { //GET category by Id
    return ResponseEntity.ok(categoryService.getCategoryById(id));
  }
  
  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody Category category) { //POST - create a new category
    return ResponseEntity.ok(categoryService.createCategory(category));
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) { //PUT - update category by id
    return ResponseEntity.ok(categoryService.updateCategory(category));
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id) { //DELETE - Delete category by id
    categoryService.deleteCategory(id);
    return ResponseEntity.noContent().build();
  }
}

