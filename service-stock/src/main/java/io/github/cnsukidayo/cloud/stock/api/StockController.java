package io.github.cnsukidayo.cloud.stock.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyuanjie
 * @date 2024/1/10 18:19
 */
@RestController()
@RequestMapping("/api/stock/inner")
public class StockController {

    @Value("${server.port}")
    private String port;

    @GetMapping("reduce")
    public String reduce() {
        return "扣减库存" + port;
    }

    @GetMapping("reduceE")
    public String reduceE() {
        int a = 1 / 0;
        return "扣减库存" + port;
    }

}
