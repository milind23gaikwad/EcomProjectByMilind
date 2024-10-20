package in.eco.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import in.eco.main.entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Page<Products> findAll(Pageable pageable);
}
