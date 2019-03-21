package com.jeff_code.jpatest.quickstart.controller;

import com.jeff_code.jpatest.quickstart.entity.Customer;
import com.jeff_code.jpatest.quickstart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author: jefflike
 * @create: 2018/10/10
 * @describe:
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // 什么防止循环调用的错误
    @RequestMapping("index1")
    public String index(){
        return "index1";
    }

//    http://127.0.0.1:8080/insert?lastName=%27jeff%27&email=%27123@qq.com%27&age=12
    @RequestMapping(value = "/insert")
    @ResponseBody
    public String insertCustomer(Customer customer){
        customer.setCreatedTime(new Date());
        customer.setBirth(new Date(1537169513));
        Customer save = customerService.save(customer);
        return save.toString();
    }
}
