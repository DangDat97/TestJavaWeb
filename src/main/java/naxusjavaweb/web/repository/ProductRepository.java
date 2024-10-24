package naxusjavaweb.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import naxusjavaweb.web.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Custom method to find products by category ID with pagination
    Page<Product> findByCategoryId(int categoryId, Pageable pageable);

    // The following methods are provided by JpaRepository:
    // findAll(Pageable pageable)
    // findById(Integer id)
    // save(Product product)
}