package com.jeff_code.jpatest.quickstart.dao;

import com.jeff_code.jpatest.quickstart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: jefflike
 * @create: 2018/10/10
 * @describe:
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
