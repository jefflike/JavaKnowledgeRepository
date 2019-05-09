package com.jeff_code.estudy.teacher.controller;

import com.jeff_code.estudy.bean.EduTeacher;
import com.jeff_code.estudy.bean.SysSubject;
import com.jeff_code.estudy.teacher.service.SysSubjectService;
import com.jeff_code.estudy.teacher.service.TeacherService;
import com.jeff_code.estudy.util.Page;
import com.jeff_code.estudy.util.TeacherParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: jefflike
 * @create: 2018/10/17
 * @describe:
 */
@Controller
public class EduTeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SysSubjectService sysSubjectService;

    @ResponseBody
    @RequestMapping("/saveTeacher/saveTeacher")
    public Boolean saveTeacher(@RequestBody EduTeacher eduTeacher){
        Boolean flag = teacherService.insertTeacher(eduTeacher);
        return flag;
    }

    @ResponseBody
    @RequestMapping("/selectTeacher/selectTeacher/{pageno}")
    public Page<EduTeacher> selectTeacher(@PathVariable("pageno") String pageno){
        Page<EduTeacher> eduTeacherPage = teacherService.selectTeacher(pageno);
        return eduTeacherPage;
    }

    @ResponseBody
    @RequestMapping("/selectOne/selectOne/{userId}")
    EduTeacher selectOne(@PathVariable("userId") Integer userId){
        return teacherService.selectOne(userId);
    }

    @ResponseBody
    @RequestMapping("/selectSubj/selectSubj")
    List<SysSubject> selectSubj(){
        return  sysSubjectService.selectAll();
    }

    @ResponseBody
    @RequestMapping("/selectTeacherBy/selectTeacherBy")
    Page<EduTeacher> selectTeacherBy(@RequestBody TeacherParam param){
        return teacherService.selectTeacherBy(param);
    }

    @ResponseBody
    @RequestMapping("/deleteTecBy/deleteTecBy/{tecId}")
    void deleteTecBy(@PathVariable("tecId") String tecId){
        teacherService.deleteTecBy(tecId);
    }
}
