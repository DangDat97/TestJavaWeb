package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Product;
// import naxusjavaweb.web.entity.ProductImage;
import naxusjavaweb.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // public Optional<Product> getProductById(Long id) {
    // return productRepository;
    // }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // @Transactional
    // public void deleteProduct(Long id) {
    // productRepository.deleteById(id);
    // }

    // @Transactional
    // public Product updateProduct(Long id, Product updatedProduct) {
    // return productRepository.findById(id)
    // .map(product -> {
    // product.setName(updatedProduct.getName());
    // product.setPrice(updatedProduct.getPrice());
    // product.setDescription(updatedProduct.getDescription());
    // product.setDetail(updatedProduct.getDetail());
    // product.setDistributor(updatedProduct.getDistributor());
    // product.setCategories(updatedProduct.getCategories());
    // return productRepository.save(product);
    // })
    // .orElseGet(() -> {
    // updatedProduct.setId(id);
    // return productRepository.save(updatedProduct);
    // });
    // }

    // @Transactional
    // public Product addImageToProduct(Long productId, ProductImage image) {
    // return productRepository.findById(productId)
    // .map(product -> {
    // product.addImage(image);
    // return productRepository.save(product);
    // })
    // .orElseThrow(() -> new RuntimeException("Product not found"));
    // }

    // @Transactional
    // public Product removeImageFromProduct(Long productId, Long imageId) {
    // return productRepository.findById(productId)
    // .map(product -> {
    // product.getImages().removeIf(image -> image.getId().equals(imageId));
    // return productRepository.save(product);
    // })
    // .orElseThrow(() -> new RuntimeException("Product not found"));
    // }
}