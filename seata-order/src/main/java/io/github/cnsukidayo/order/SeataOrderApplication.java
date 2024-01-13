package io.github.cnsukidayo.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author guyuanjie
 * @date 2024/1/13 15:47
 */
@SpringBootApplication
@MapperScan(basePackages = "io.github.cnsukidayo.order.dao")
@EnableFeignClients
public class SeataOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderApplication.class,args);
    }
}
