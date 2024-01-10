package io.github.cnsukidayo.cloud.ribbon;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Configuration;

/**
 * @author guyuanjie
 * @date 2024/1/10 14:41
 */
@Configuration
public class RibbonConfig {

    public IRule iRule() {
        return new NacosRule();
    }

}
