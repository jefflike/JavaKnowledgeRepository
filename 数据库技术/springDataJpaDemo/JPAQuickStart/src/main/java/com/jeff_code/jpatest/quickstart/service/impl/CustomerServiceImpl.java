package com.jeff_code.jpatest.quickstart.service.impl;

import com.jeff_code.jpatest.quickstart.dao.CustomerRepository;
import com.jeff_code.jpatest.quickstart.entity.Customer;
import com.jeff_code.jpatest.quickstart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jefflike
 * @create: 2018/10/10
 * @describe:
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        // insert
        Customer save = customerRepository.save(customer);
        return save;
    }
}
