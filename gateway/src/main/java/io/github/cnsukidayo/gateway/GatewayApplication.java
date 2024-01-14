package io.github.cnsukidayo.gateway;

import com.alibaba.csp.sentinel.config.SentinelConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sukidayo
 * @date 2024/1/14 14:06
 */
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        System.setProperty(SentinelConfig.APP_TYPE_PROP_KEY,"11");
        SpringApplication.run(GatewayApplication.class, args);
    }
}
