package nl.fredtieken.eriksdigital;

import nl.fredtieken.eriksdigital.entity.OrderDTO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EriksdigitalApplicationTests {

    private static Logger LOGGER = LoggerFactory.getLogger(EriksdigitalApplicationTests.class);

    @Autowired
    private OrderService orderService;

    @Test
    void getOrder() {
        OrderDTO order = orderService.getOrder(1L);
        assertEquals(12.50, order.getPrice());
    }

    @Test
    void testUpdate() {
        OrderDTO newOrder = new OrderDTO();
        newOrder.setStatus("NEW");
        newOrder.setId(1);
        orderService.updateOrderStatus(newOrder);
        OrderDTO order = orderService.getOrder(1L);
        assertEquals("NEW", order.getStatus());
    }

    @Test
    void deleteOrder() {
        OrderDTO order = orderService.getOrder(4L);
        assertNotNull(order);
        orderService.deleteOrder(4L);
        OrderDTO order2 = orderService.getOrder(4L);
        assertNull(order2);
    }

    @Test
    void createOrder() {
        OrderDTO dto = new OrderDTO();
        dto.setStatus("NEW");
        dto.setDate(new Date());
        dto.setPrice(99.99);
        Long aLong = orderService.saveOrder(dto);
        assertNotNull(aLong);
        OrderDTO savedOrder = orderService.getOrder(aLong);
        assertNotNull(savedOrder);
    }

}
