package nl.fredtieken.eriksdigital.controller;


import nl.fredtieken.eriksdigital.entity.OrderDTO;
import nl.fredtieken.eriksdigital.entity.ResponseDTO;
import nl.fredtieken.eriksdigital.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {

        OrderDTO order = orderService.getOrder(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
        LOGGER.error("Not found order: {}", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> addOrder(@RequestBody OrderDTO order) {
        Long newId = orderService.saveOrder(order);
        LOGGER.info("Saved order to id = {}" , newId);
        ResponseDTO response = new ResponseDTO(newId);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder (@PathVariable Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> UpdateOrderStatus(@RequestBody OrderDTO order) {
        if (order.getStatus() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        orderService.updateOrderStatus(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
