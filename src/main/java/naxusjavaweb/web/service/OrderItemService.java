package naxusjavaweb.web.service;

import naxusjavaweb.web.entity.OrderItem;
import java.util.List;
import java.util.Optional;

public interface OrderItemService {

    List<OrderItem> getAllOrderItems();

    Optional<OrderItem> getOrderItemById(Long id);

    OrderItem saveOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long id);

    List<OrderItem> getOrderItemsByOrderId(Long orderId);

    List<OrderItem> getOrderItemsByProductId(Long productId);

    // Additional methods as needed
}