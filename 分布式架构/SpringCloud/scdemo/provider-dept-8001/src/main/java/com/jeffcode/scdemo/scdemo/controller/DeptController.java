package com.jeffcode.scdemo.scdemo.controller;

import com.jeffcode.scdemo.entities.Dept;
import com.jeffcode.scdemo.scdemo.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DeptController
{
	@Autowired
	private DeptService service;

	@RequestMapping("/dept/sessionId")
	public Object id(HttpServletRequest request) {
		return request.getSession().getId() ;
	}

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod="getFallback") // 如果当前调用的get()方法出现了错误，则执行fallback
	public Dept get(@PathVariable("id") Long id)
	{
        Dept dept = service.get(id);
        if (dept == null) { // 数据不存在，假设让它抛出个错误
            throw new RuntimeException("部门信息不存在！") ;
        }

        return dept;
	}

    public Object getFallback(@PathVariable("id") Long id) { // 此时方法的参数 与get()一致
        Dept dept = new Dept() ;
        dept.setDeptno(999999L);
        dept.setDname("【ERROR】Microcloud-Dept-Hystrix"); // 错误的提示
        dept.setDb_source("DEPT-Provider");
        return dept ;
    }

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

	// 2018.3.11
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
