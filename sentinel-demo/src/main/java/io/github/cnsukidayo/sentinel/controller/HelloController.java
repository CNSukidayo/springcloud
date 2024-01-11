package io.github.cnsukidayo.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import io.github.cnsukidayo.sentinel.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guyuanjie
 * @date 2024/1/11 14:05
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class HelloController {


    public static final String RESOURCE_NAME = "hello";
    public static final String USER_RESOURCE_NAME = "user";
    public static final String DEGRADE_RESOURCE_NAME = "degrade";

    @RequestMapping(value = "hello")
    public String hello() {
        Entry entry = null;
        try {
            // 定义资源名称,通常与接口请求地址一致
            entry = SphU.entry(RESOURCE_NAME);
            String str = "hello world";
            log.info("============" + str + "===========");
            return str;
        } catch (BlockException e) {
            log.info("block");
            return "被流控了!";
        } catch (Exception exception) {
            // 若需要配置降级规则,需要使用这种方式记录业务异常
            Tracer.traceEntry(exception, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

        return null;
    }

    // 初始化方法
    @PostConstruct
    private static void initFlowRules() {
        // 流控规则集合
        List<FlowRule> rules = new ArrayList<>();

        // 一个FlowRule就是一个流控规则
        FlowRule rule0 = new FlowRule();
        /*
        为哪个资源进行流控的规则限制
        这里就和上面controller中的方法对应起来了
        表明当前rule是针对上述RESOURCE_NAME的规则进行限制的,谁用了这个资源就会被该规则流控
         */
        rule0.setResource(RESOURCE_NAME);
        // 设置流控规则为QPS(实际上还有很多规则可以参考官方文档)
        rule0.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 设置受保护的阈值,每秒只有一次
        rule0.setCount(1);
        rules.add(rule0);

        FlowRule rule1 = new FlowRule();
        rule1.setResource(USER_RESOURCE_NAME);
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setCount(1);
        rules.add(rule1);

        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    @RequestMapping("user")
    @SentinelResource(value = USER_RESOURCE_NAME, blockHandler = "blockHandlerForGetUser")
    public User getUser(String id) {
        return new User("蔡徐坤");
    }

    /**
     * 流控方法必须为public
     * 方法返回值必须与被流控方法(原方法)保持一致
     * 参数必须与原方法保持一致(并且顺序也一直)
     * 可以在流控方法最后添加一个BlockException(可以通过该异常获取当前是类似类型的流控)
     *
     * @param id 拿到被流控方法的入参
     * @param e  拿到异常
     */
    public User blockHandlerForGetUser(String id, BlockException e) {
        e.printStackTrace();
        return new User("流控");
    }

    @RequestMapping("degrade")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME, entryType = EntryType.IN, blockHandler = "blockHandlerForFb")
    public User degrade(String id) {
        throw new RuntimeException("异常");
    }

    public User blockHandlerForFb(String id, BlockException e) {
        return new User("熔断");
    }

    @PostConstruct
    public void initDegradeRule() {
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(DEGRADE_RESOURCE_NAME);
        // 设置规则策略:异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // 阈值
        degradeRule.setCount(2);
        // 触发熔断最小请求数
        degradeRule.setMinRequestAmount(2);
        // 统计时长,一分钟执行了两次出现了两次异常则触发熔断
        degradeRule.setStatIntervalMs(60 * 1000);

        /*
        熔断降级独有的,设置熔断持续时长,一旦熔断之后在这个时间窗口内的所有请求都熔断
        时间窗口结束之后会恢复方法的请求,但如果在恢复之后第一次调用方法就出现异常则会直接熔断
         */
        degradeRule.setTimeWindow(10);


        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);
    }


}
