package com.jeff_code.estudy.teacher.service.impl;

import com.jeff_code.estudy.bean.EduTeacher;
import com.jeff_code.estudy.teacher.mapper.TeacherMapper;
import com.jeff_code.estudy.teacher.service.TeacherService;
import com.jeff_code.estudy.util.Page;
import com.jeff_code.estudy.util.TeacherParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: jefflike
 * @create: 2018/10/17
 * @describe:
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Page<EduTeacher> selectTeacher(String pageno) {
        List<EduTeacher> eduTeachers = teacherMapper.selectAll();
        Page<EduTeacher>  page = new Page<>(Integer.parseInt(pageno),5);
        page.setTotalsize(eduTeachers.size()==0?1:eduTeachers.size());
        List<EduTeacher> list = teacherMapper.selectPage(page.getStartindex(),page.getPagesize());
        page.setDatas(list);
        return page;
    }

    @Override
    public EduTeacher selectOne(Integer id) {
        EduTeacher teacher = new EduTeacher();
        teacher.setId(id);
        EduTeacher eduTeacher = teacherMapper.selectOne(teacher);
        return eduTeacher;
    }

    @Override
    public Page<EduTeacher> selectTeacherBy(TeacherParam param) {
        param.setCreateTime(param.getCreateTime().trim());
        param.setUpdateTime(param.getUpdateTime().trim());
        param.setName(param.getName().trim());
        List<EduTeacher> eduTeachers = teacherMapper.selectByParam(param);
        Page<EduTeacher>  page = new Page<>(param.getPageno(),5);
        page.setTotalsize(eduTeachers.size()==0?1:eduTeachers.size());

        List<EduTeacher> list = getList(page.getStartindex(),page.getPagesize(),eduTeachers);
        page.setDatas(list);
        return page;
    }

    private List<EduTeacher> getList(int startindex, int pagesize, List<EduTeacher> eduTeachers) {
        List<EduTeacher> list = new ArrayList<>();
        if(eduTeachers.size()<=0){
            return null;
        }
        int end = (startindex+pagesize)<=eduTeachers.size()?(startindex+pagesize):eduTeachers.size();
        for (int i = startindex; i < end; i++) {
            list.add(eduTeachers.get(i));
        }
        return list;
    }

    @Override
    public Boolean insertTeacher(EduTeacher eduTeacher) {
        eduTeacher.setStatus((byte) 0);
        eduTeacher.setCreateTime(new Date());
        eduTeacher.setUpdateTime(new Date());
        int insert = teacherMapper.insert(eduTeacher);
        if(insert == 0){
            return false;
        }
        return true;
    }

    @Override
    public void deleteTecBy(String tecId) {
        EduTeacher eduTeacher = new EduTeacher();
        eduTeacher.setId(Integer.parseInt(tecId));
        teacherMapper.delete(eduTeacher);
    }
}
