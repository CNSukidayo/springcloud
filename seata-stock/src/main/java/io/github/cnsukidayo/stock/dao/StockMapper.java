package io.github.cnsukidayo.stock.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:33
 */
@Mapper
public interface StockMapper {

    void reduce(@Param("productId") Integer productId);

}
