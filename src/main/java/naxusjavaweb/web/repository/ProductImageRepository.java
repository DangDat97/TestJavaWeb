package naxusjavaweb.web.repository;

import naxusjavaweb.web.entity.Product;
import naxusjavaweb.web.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findByProduct(Product product);

    List<ProductImage> findByProductId(int productId);
}