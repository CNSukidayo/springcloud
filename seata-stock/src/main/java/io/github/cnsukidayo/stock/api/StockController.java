package io.github.cnsukidayo.stock.api;

import io.github.cnsukidayo.stock.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:20
 */
@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("reduce/{productId}")
    public void reduce(@PathVariable("productId") Integer productId) {
        stockService.reduce(productId);
    }


}
