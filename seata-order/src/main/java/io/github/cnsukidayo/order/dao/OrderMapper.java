package io.github.cnsukidayo.order.dao;

import io.github.cnsukidayo.order.entity.Order;

import java.util.List;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:12
 */
public interface OrderMapper {

    List<Order> list();

    void insert(Order order);

}
