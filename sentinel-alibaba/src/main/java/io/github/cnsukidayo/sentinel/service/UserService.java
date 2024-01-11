package io.github.cnsukidayo.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author guyuanjie
 * @date 2024/1/11 18:51
 */
@Service
public class UserService {


    @SentinelResource(value = "getUser")
    public String getUser() {
        return "getUser";
    }

}
