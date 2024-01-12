package io.github.cnsukidayo.sentinel.openfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author guyuanjie
 * @date 2024/1/12 15:41
 */
@FeignClient(value = "service-stock", path = "/api/stock/inner",fallback = StockFeignServiceFallback.class)
public interface StockFeignService {

    @GetMapping("reduceE")
    String reduceE();

}
