package io.github.cnsukidayo.cloud.order.feign;

import io.github.cnsukidayo.cloud.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author guyuanjie
 * @date 2024/1/10 18:13
 */
@FeignClient(name = "service-stock", path = "/api/stock/inner", configuration = FeignConfig.class)
public interface StockFeignService {

    @GetMapping("reduce")
    String reduce();
}
