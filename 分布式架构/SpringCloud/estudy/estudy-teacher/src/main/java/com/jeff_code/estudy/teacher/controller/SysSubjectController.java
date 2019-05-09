package com.jeff_code.estudy.teacher.controller;

import com.jeff_code.estudy.bean.SysSubject;
import com.jeff_code.estudy.teacher.service.SysSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysSubjectController {
    @Autowired
    private SysSubjectService sysSubjectService;
    @RequestMapping("/selectChild/selectChild/{parentId}")
    List<SysSubject> selectChild(@PathVariable("parentId") Integer parentId){
        return sysSubjectService.selectChild(parentId);
    }

    @RequestMapping("/selectBroth/selectBroth/{subjectId}")
    List<SysSubject> selectBroth(@PathVariable("subjectId") Integer subjectId){
        return  sysSubjectService.selectBroth(subjectId);
    }
}
