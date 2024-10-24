package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.Order;
import naxusjavaweb.web.entity.OrderItem;
// import naxusjavaweb.web.entity.Product;
import naxusjavaweb.web.entity.User;
import naxusjavaweb.web.repository.OrderRepository;
// import naxusjavaweb.web.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // @Autowired
    // private ProductRepository productRepository;

    @Transactional
    public Order createOrder(User user, List<OrderItem> items) {
        Order order = new Order();
        order.setUser(user);
        order.setOrderItems(items);

        BigDecimal total = BigDecimal.ZERO;
        // for (OrderItem item : items) {
        // // Product product = productRepository.findById(item.getProduct().getId())
        // // .orElseThrow(() -> new RuntimeException("Product not found"));

        // // item.setPrice(product.getPrice());
        // // item.setOrder(order);
        // // total = total.add(item.getPrice().multiply(new
        // // BigDecimal(item.getQuantity())));
        // }

        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUserId(user.getId());
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}