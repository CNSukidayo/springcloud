package io.github.cnsukidayo.cloud.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author guyuanjie
 * @date 2024/1/9 16:35
 */
@SpringBootApplication
public class StockApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StockApplication.class, args);
        System.out.println(applicationContext.getEnvironment().getProperty("test.name"));
    }
}
