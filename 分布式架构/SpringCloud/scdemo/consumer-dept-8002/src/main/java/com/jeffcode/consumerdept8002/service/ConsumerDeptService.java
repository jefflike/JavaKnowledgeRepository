package com.jeffcode.consumerdept8002.service;

import com.jeffcode.scdemo.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "microservicecloud-dept", fallbackFactory = IConsumerDeptServiceFallbackFactory.class)
public interface ConsumerDeptService {
    @RequestMapping(method= RequestMethod.GET,value="/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) ;
    @RequestMapping(method=RequestMethod.GET,value="/dept/list")
    public List<Dept> list() ;
    @RequestMapping(method=RequestMethod.POST,value="/dept/add")
    public boolean add(Dept dept) ;
}
