package io.github.cnsukidayo.sentinel.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cnsukidayo.sentinel.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guyuanjie
 * @date 2024/1/11 17:20
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(MyBlockExceptionHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        // getRule() 获取规则的详情信息
        logger.info("BlockException ===============>" + e.getRule());
        Result r = null;
        if (e instanceof FlowException) {
            r = Result.error(101, "接口限流了");
        } else if (e instanceof DegradeException) {
            r = Result.error(102, "服务降级了");
        } else if (e instanceof ParamFlowException) {
            r = Result.error(103, "热点参数限流了");
        } else if (e instanceof SystemBlockException) {
            r = Result.error(104, "触发系统保护规则了");
        } else if (e instanceof AuthorityException) {
            r = Result.error(105, "授权规则不通过");
        }
        // 返回json数据
        response.setStatus(500);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getWriter(),r);
    }
}
