package io.github.cnsukidayo.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sukidayo
 * @date 2024/1/14 14:33
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

}
