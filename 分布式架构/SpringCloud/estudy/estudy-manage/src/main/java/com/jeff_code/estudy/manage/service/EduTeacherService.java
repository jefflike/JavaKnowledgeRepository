package com.jeff_code.estudy.manage.service;

import com.jeff_code.estudy.bean.EduTeacher;
import com.jeff_code.estudy.bean.SysSubject;
import com.jeff_code.estudy.util.Page;
import com.jeff_code.estudy.util.TeacherParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: jefflike
 * @create: 2018/10/17
 * @describe:
 */
@FeignClient("teacher-service")
public interface EduTeacherService {

    @RequestMapping("/saveTeacher/saveTeacher")
    public Boolean saveTeacher(@RequestBody EduTeacher eduTeacher);

    @RequestMapping("/selectTeacher/selectTeacher/{pageno}")
    public Page<EduTeacher> selectTeacher(@PathVariable("pageno") String pageno);

    @RequestMapping("/selectSubj/selectSubj")
    List<SysSubject> selectSubj();

    @RequestMapping("/selectOne/selectOne/{userId}")
    EduTeacher selectOne(@PathVariable("userId") Integer userId);

    @RequestMapping("/selectBroth/selectBroth/{subjectId}")
    List<SysSubject> selectBroth(@PathVariable("subjectId") Integer subjectId);

    @RequestMapping("/selectTeacherBy/selectTeacherBy")
    Page<EduTeacher> selectTeacherBy(@RequestBody TeacherParam param);

    @RequestMapping("/selectChild/selectChild/{parentId}")
    List<SysSubject> selectChild(@PathVariable("parentId") Integer parentId);
}
