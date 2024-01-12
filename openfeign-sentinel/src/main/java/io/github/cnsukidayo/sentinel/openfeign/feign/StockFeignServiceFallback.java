package io.github.cnsukidayo.sentinel.openfeign.feign;

import org.springframework.stereotype.Component;

/**
 * @author guyuanjie
 * @date 2024/1/12 15:56
 */
@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduceE() {
        return null;
    }
}
