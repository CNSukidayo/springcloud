package io.github.cnsukidayo.stock.service.impl;

import io.github.cnsukidayo.stock.dao.StockMapper;
import io.github.cnsukidayo.stock.service.StockService;
import org.springframework.stereotype.Service;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:32
 */
@Service
public class StockServiceImpl implements StockService {

    private final StockMapper stockMapper;

    public StockServiceImpl(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    @Override
    public void reduce(Integer productId) {
        stockMapper.reduce(productId);
    }
}
