package io.github.cnsukidayo.cloud.order.controller;

import io.github.cnsukidayo.cloud.order.feign.StockFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyuanjie
 * @date 2024/1/10 18:27
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final StockFeignService stockFeignService;

    public OrderController(StockFeignService stockFeignService) {
        this.stockFeignService = stockFeignService;
    }

    @GetMapping("add")
    public String add() {
        return stockFeignService.reduce();
    }

}
