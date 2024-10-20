package in.eco.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.eco.main.entities.Category;
import in.eco.main.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
	     @Override
		  public Category getCategoryById(Long id) {
			  Optional <Category> optionalCategory =categoryRepository.findById(id);
		    return optionalCategory.get();
		  }
		  @Override
		  public Category createCategory(Category category) {
		    return categoryRepository.save(category);
		  }
		  
		  @Override
		  public Category updateCategory(Category category) {
		      Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
		      if (optionalCategory.isPresent()) {
		          Category existingCategory = optionalCategory.get();
		      
		          if (category.getName() != null) {
		              existingCategory.setName(category.getName());
		          }
		          return categoryRepository.save(existingCategory);
		      } else {
		          
		          throw new RuntimeException("Category not found");
		      }
		  }

		  
		  
		  @Override
		  public void deleteCategory(Long id) {
			  categoryRepository.deleteById(id);
  
   }
}





