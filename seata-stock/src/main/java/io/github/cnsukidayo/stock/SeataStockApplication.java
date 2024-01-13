package io.github.cnsukidayo.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guyuanjie
 * @date 2024/1/13 16:19
 */
@SpringBootApplication
@MapperScan(basePackages = "io.github.cnsukidayo.stock.dao")
@EnableFeignClients
public class SeataStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataStockApplication.class, args);
    }
}
