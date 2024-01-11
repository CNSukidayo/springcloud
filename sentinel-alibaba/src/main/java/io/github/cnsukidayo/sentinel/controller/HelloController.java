package io.github.cnsukidayo.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author guyuanjie
 * @date 2024/1/11 14:05
 */
@RestController
@RequestMapping("/sentinel")
public class HelloController {



    @GetMapping("hello")
    public String hello() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello";
    }


}
