package in.eco.main.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.eco.main.entities.Category;

public interface CategoryService {
	
    Page<Category> getAllCategories(Pageable pageable);
    
    Category getCategoryById(Long id);
    
    Category createCategory(Category category);
    
    Category updateCategory(Category category);
    
    void deleteCategory(Long id);
}