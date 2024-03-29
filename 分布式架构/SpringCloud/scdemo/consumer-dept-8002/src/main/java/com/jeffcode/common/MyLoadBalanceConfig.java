package com.jeffcode.common;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class MyLoadBalanceConfig {
    @Bean
    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略
    }

}
