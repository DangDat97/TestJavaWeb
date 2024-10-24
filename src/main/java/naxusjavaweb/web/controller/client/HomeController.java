package naxusjavaweb.web.controller.client;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import jakarta.servlet.http.HttpSession;
// import naxusjavaweb.web.entity.Product;
// import naxusjavaweb.web.entity.ProductImage;
// import naxusjavaweb.web.repository.CartRepository;
// import naxusjavaweb.web.repository.ProductImageRepository;
// import naxusjavaweb.web.repository.ProductRepository;

// import java.util.List;
// import java.util.Optional;

@Controller
public class HomeController {
    private static final String LAYOUT = "/client/template";

    // @Autowired
    // private ProductRepository productRepository;

    // @Autowired
    // private ProductImageRepository productImageRepository;

    // @Autowired
    // private CartRepository cartRepository;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("content", "home");
        return LAYOUT;
    }

    // @GetMapping("/privacy")
    // public String privacy() {
    // return "privacy";
    // }

    // @GetMapping("/shop")
    // public String shop(@RequestParam(defaultValue = "1") int page, Model model) {
    // // int pageSize = 4;
    // // Page<Product> productPage = productRepository.findAll(
    // // PageRequest.of(page - 1, pageSize, Sort.by("name")));
    // // model.addAttribute("products", productPage);

    // return LAYOUT;
    // }

    // @GetMapping("/product-category/{id}")
    // public String productCategory(@PathVariable int id,
    // @RequestParam(defaultValue = "1") int page, Model model) {
    // // int pageSize = 4;
    // // Page<Product> productPage = productRepository.findByCategoryId(
    // // id, PageRequest.of(page - 1, pageSize, Sort.by("name")));
    // // model.addAttribute("products", productPage);
    // return LAYOUT;
    // }

    // @GetMapping("/product/{id}")
    // public String product(@PathVariable int id, Model model) {
    // // Optional<Product> productOpt = productRepository.findById(id);
    // // if (productOpt.isEmpty()) {
    // // return "not-found";
    // // }
    // // List<ProductImage> images = productImageRepository.findByProductId(id);
    // // HomeProductDetailViewModel viewModel = new
    // // HomeProductDetailViewModel(productOpt.get(), images);
    // // model.addAttribute("productDetail", viewModel);
    // return LAYOUT;
    // }

    // // ... existing code ...

    // @GetMapping("/cart")
    // public String cart(HttpSession session, Model model) {
    // // Integer userId = (Integer) session.getAttribute("IdUser");
    // // if (userId == null) {
    // // return "redirect:/auth/login";
    // // }
    // // List<Cart> cartItems = cartRepository.findByCustomerId(userId);
    // // model.addAttribute("cartItems", cartItems);
    // return LAYOUT;
    // }

    // @GetMapping("/add-to-cart/{id}")
    // public String addToCart(@PathVariable Integer id, @RequestParam(defaultValue
    // = "1") Integer quantity,
    // HttpSession session, RedirectAttributes redirectAttributes) {
    // Integer userId = (Integer) session.getAttribute("IdUser");
    // // if (userId == null) {
    // // return "redirect:/auth/login";
    // // }

    // // Optional<Product> productOpt = productRepository.findById(id);
    // // if (productOpt.isEmpty()) {
    // // redirectAttributes.addFlashAttribute("message", "Product not found with
    // id: "
    // // + id);
    // // return "redirect:/404";
    // // }

    // // Cart cartItem = cartRepository.findByProductIdAndCustomerId(id, userId);
    // // if (cartItem == null) {
    // // cartItem = new Cart();
    // // cartItem.setProductId(id);
    // // cartItem.setCustomerId(userId);
    // // cartItem.setQuantity(quantity);
    // // } else {
    // // cartItem.setQuantity(cartItem.getQuantity() + quantity);
    // // }
    // // cartRepository.save(cartItem);

    // return LAYOUT;
    // }

    // ... remaining methods ...
}