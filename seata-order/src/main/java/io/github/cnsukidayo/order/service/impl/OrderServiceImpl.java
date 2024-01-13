package io.github.cnsukidayo.order.service.impl;

import io.github.cnsukidayo.order.dao.OrderMapper;
import io.github.cnsukidayo.order.entity.Order;
import io.github.cnsukidayo.order.feign.StockFeign;
import io.github.cnsukidayo.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guyuanjie
 * @date 2024/1/13 15:54
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final StockFeign stockFeign;

    public OrderServiceImpl(OrderMapper orderMapper,
                            StockFeign stockFeign) {
        this.orderMapper = orderMapper;
        this.stockFeign = stockFeign;
    }

    @Override
    public List<Order> list() {
        return orderMapper.list();
    }

    @GlobalTransactional
    @Override
    public void add(Order order) {
        orderMapper.insert(order);
        stockFeign.reduce(order.getProductId());
        int i  = 1 / 0;
    }
}
