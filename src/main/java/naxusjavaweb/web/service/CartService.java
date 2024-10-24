package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Cart;
// import naxusjavaweb.web.entity.Product;
import naxusjavaweb.web.entity.User;
import naxusjavaweb.web.repository.CartRepository;
import naxusjavaweb.web.repository.ProductRepository;
import naxusjavaweb.web.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    // private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository,
            ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        // this.productRepository = productRepository;
    }

    public List<Cart> getCartItemsByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Transactional
    public Cart addToCart(Long customerId, Long productId, Integer quantity) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        // Product product = productRepository.findById(productId)
        // .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<Cart> existingCartItem = cartRepository.findByCustomerIdAndProductId(customerId, productId);

        if (existingCartItem.isPresent()) {
            Cart cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            return cartRepository.save(cartItem);
        } else {
            Cart newCartItem = new Cart();
            newCartItem.setCustomer(customer);
            // newCartItem.setProduct(product);
            newCartItem.setQuantity(quantity);
            return cartRepository.save(newCartItem);
        }
    }

    @Transactional
    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    @Transactional
    public void updateCartItemQuantity(Long cartItemId, Integer newQuantity) {
        Cart cartItem = cartRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItem.setQuantity(newQuantity);
        cartRepository.save(cartItem);
    }

    @Transactional
    public void clearCart(Long customerId) {
        List<Cart> cartItems = cartRepository.findByCustomerId(customerId);
        cartRepository.deleteAll(cartItems);
    }

    @Transactional
    public void removeProductFromAllCarts(Long productId) {
        cartRepository.deleteByProductId(productId);
    }
}