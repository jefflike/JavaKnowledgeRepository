package com.jeff_code.estudy.teacher.mapper;

import com.jeff_code.estudy.bean.EduTeacher;
import com.jeff_code.estudy.util.TeacherParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author: jefflike
 * @create: 2018/10/17
 * @describe:
 */
public interface TeacherMapper extends Mapper<EduTeacher> {
    List<EduTeacher> selectPage(int startindex, int pagesize);

    List<EduTeacher> selectByParam(TeacherParam param);
}
