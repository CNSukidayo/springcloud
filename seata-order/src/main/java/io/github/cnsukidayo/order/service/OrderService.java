package io.github.cnsukidayo.order.service;

import io.github.cnsukidayo.order.entity.Order;

import java.util.List;

/**
 * @author guyuanjie
 * @date 2024/1/13 15:53
 */
public interface OrderService {


    List<Order> list();

    void add(Order order);
}
