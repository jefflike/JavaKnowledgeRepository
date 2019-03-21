package com.jeff_code.jpatest.quickstart.dao;

import com.jeff_code.jpatest.quickstart.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: jefflike
 * @create: 2018/10/10
 * @describe:
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
