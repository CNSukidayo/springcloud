package io.github.cnsukidayo.sentinel.controller;

import io.github.cnsukidayo.sentinel.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guyuanjie
 * @date 2024/1/11 18:51
 */
@RestController
@RequestMapping("/sentinel")
public class TestController {

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("test1")
    public String test1() {
        return userService.getUser();
    }

    @GetMapping("test2")
    public String test2() {
        return userService.getUser();
    }


}
