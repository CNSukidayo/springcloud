package io.github.cnsukidayo.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:30
 */
@FeignClient(name = "seata-stock", path = "/api/stock")
public interface StockFeign {

    @GetMapping("reduce/{productId}")
    void reduce(@PathVariable("productId") Integer productId);

}
