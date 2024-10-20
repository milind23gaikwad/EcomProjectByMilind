package in.eco.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import in.eco.main.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAll(Pageable pageable);
}