package nl.fredtieken.eriksdigital.service;

import nl.fredtieken.eriksdigital.entity.OrderDTO;
import nl.fredtieken.eriksdigital.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Class to handle the orders.
 */
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Get the order
     * @param id the order ID
     * @return the complete Order
     */
    public OrderDTO getOrder(Long id) {
        if (id == null) {
            return null;
        }
        Optional<OrderDTO> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    /**
     * Save the Order
     * @param orderDTO the order info
     * @return the created order id
     */
    public Long saveOrder(OrderDTO orderDTO) {
        OrderDTO savedOrder = orderRepository.save(orderDTO);
        return savedOrder.getId();
    }

    /**
     * Deletes the order
     * @param orderId the order ID
     */
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    /**
     * Updates the order status
     * @param order the order with order id and new status
     */
    public void updateOrderStatus(OrderDTO order) {
        Optional<OrderDTO> optionalOrder = orderRepository.findById(order.getId());

        optionalOrder.ifPresent(orderFetched -> {
            if (!order.getStatus().equals(orderFetched.getStatus())) {
                orderFetched.setStatus(order.getStatus());
                orderRepository.save(orderFetched);
                LOGGER.info("Order {} status changed {} -> {}", order.getId(), orderFetched.getStatus(), order.getStatus());
            }
        });
    }

}
