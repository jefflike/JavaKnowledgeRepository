package com.jeffcode.consumerdept8002.controller;

import java.util.List;

import javax.annotation.Resource;

import com.jeffcode.consumerdept8002.service.ConsumerDeptService;
import com.jeffcode.scdemo.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerDeptController {
	public static final String DEPT_GET_URL = "http://MICROSERVICECLOUD-DEPT/dept/get/";
	public static final String DEPT_LIST_URL = "http://MICROSERVICECLOUD-DEPT/dept/list/";
	public static final String DEPT_ADD_URL = "http://MICROSERVICECLOUD-DEPT/dept/add";
	@Resource
	private RestTemplate restTemplate;

	@Resource
	private HttpHeaders headers;

	@RequestMapping(value = "/consumer/dept/get")
	public Object getDeptAuth(long id) {
		Dept dept = this.restTemplate
				.exchange(DEPT_GET_URL + id, HttpMethod.GET,
						new HttpEntity<Object>(this.headers), Dept.class)
				.getBody();
		return dept;
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Object getDept(@PathVariable("id") long id) {
		Dept dept = this.restTemplate.getForObject(DEPT_GET_URL + id,
				Dept.class);
		return dept;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public Object listDept() {
		List<Dept> allDepts = this.restTemplate.getForObject(DEPT_LIST_URL,
				List.class); 
		return allDepts;
	}
	@RequestMapping(value = "/consumer/dept/add")
	public Object addDept(Dept dept) {
		Boolean flag = this.restTemplate.postForObject(DEPT_ADD_URL, dept,
				Boolean.class);
		return flag;
	}

	// 以下使用Feign的调用方式
	@Autowired
	private ConsumerDeptService consumerDeptService;

	@RequestMapping(value = "/consumer/feign/dept/get/{id}")
	public Object getFeignDept(@PathVariable("id") long id) {
		Dept dept = consumerDeptService.get(id);
		return dept;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/feign/dept/list")
	public Object listFeignDept() {
		List<Dept> allDepts = consumerDeptService.list();
		return allDepts;
	}
	@RequestMapping(value = "/consumer/feign/dept/add")
	public Object addFeignDept(Dept dept) {
		Boolean flag = consumerDeptService.add(dept);
		return flag;
	}
}
