package com.jeff_code.jpatest.quickstart.dao;

import com.jeff_code.jpatest.quickstart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: jefflike
 * @create: 2018/10/10
 * @describe:
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
