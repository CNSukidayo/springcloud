package io.github.cnsukidayo.order.controller;

import io.github.cnsukidayo.order.entity.Order;
import io.github.cnsukidayo.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyuanjie
 * @date 2024/1/13 15:49
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("add/{id}")
    public void add(@PathVariable("id") Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setProductId(9);
        order.setTotalAmount(100);
        order.setStatus(0);
        orderService.add(order);
    }

}
