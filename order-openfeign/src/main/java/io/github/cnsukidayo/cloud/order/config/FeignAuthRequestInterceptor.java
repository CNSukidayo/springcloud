package io.github.cnsukidayo.cloud.order.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * @author sukidayo
 * @date 2024/1/10 21:40
 */
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        System.out.println("==============请求");
        // 业务逻辑
        String access_token = UUID.randomUUID().toString();
        template.header("Authorization", access_token);
    }
}
