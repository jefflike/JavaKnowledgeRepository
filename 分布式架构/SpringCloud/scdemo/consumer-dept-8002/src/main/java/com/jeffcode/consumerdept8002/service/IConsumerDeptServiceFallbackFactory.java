package com.jeffcode.consumerdept8002.service;

import com.jeffcode.scdemo.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IConsumerDeptServiceFallbackFactory implements FallbackFactory<ConsumerDeptService> {
    @Override
    public ConsumerDeptService create(Throwable throwable) {
        return new ConsumerDeptService() {
            @Override
            public Dept get(long id) {
                Dept vo = new Dept();
                vo.setDeptno(888888L);
                vo.setDname("【ERROR】Feign-Hystrix"); // 错误的提示
                vo.setDb_source("Consumer客户端提供");
                return vo;
            }
            @Override
            public List<Dept> list() {
                return null;
            }
            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    } ;
}
