package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Product;
import naxusjavaweb.web.entity.ProductImage;
import naxusjavaweb.web.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Transactional
    public ProductImage saveProductImage(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    public Optional<ProductImage> getProductImageById(Long id) {
        return productImageRepository.findById(id);
    }

    public List<ProductImage> getProductImagesByProduct(Product product) {
        return productImageRepository.findByProduct(product);
    }

    @Transactional
    public void deleteProductImage(Long id) {
        productImageRepository.deleteById(id);
    }

    @Transactional
    public ProductImage updateProductImage(Long id, String newImagePath) {
        Optional<ProductImage> optionalProductImage = productImageRepository.findById(id);
        if (optionalProductImage.isPresent()) {
            ProductImage productImage = optionalProductImage.get();
            productImage.setImagePath(newImagePath);
            return productImageRepository.save(productImage);
        }
        return null;
    }
}