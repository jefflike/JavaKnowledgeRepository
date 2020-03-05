package com.jeffcode.scdemo.scdemo.service;

import com.jeffcode.scdemo.entities.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DeptServiceTest {

    @Autowired
    private DeptService deptService;

    @Test
    public void add() {
        System.out.println(deptService.add(new Dept("吹牛部").setDb_source("cloudDB01")));
    }

    @Test
    public void get() {
        System.out.println(deptService.get(2L));
    }

    @Test
    public void list() {
        deptService.list().forEach(System.out::println);
    }
}