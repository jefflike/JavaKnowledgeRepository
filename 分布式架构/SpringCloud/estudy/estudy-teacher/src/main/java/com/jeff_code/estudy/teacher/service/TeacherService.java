package com.jeff_code.estudy.teacher.service;

import com.jeff_code.estudy.bean.EduTeacher;
import com.jeff_code.estudy.util.Page;
import com.jeff_code.estudy.util.TeacherParam;

/**
 * @Author: jefflike
 * @create: 2018/10/17
 * @describe:
 */
public interface TeacherService {

    Boolean insertTeacher(EduTeacher eduTeacher);

    Page<EduTeacher> selectTeacher(String pageno);

    EduTeacher selectOne(Integer userId);

    void deleteTecBy(String tecId);

    Page<EduTeacher> selectTeacherBy(TeacherParam param);
}
