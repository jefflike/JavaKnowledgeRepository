package com.jeff_code.estudy.teacher.service.impl;

import com.jeff_code.estudy.bean.SysSubject;
import com.jeff_code.estudy.teacher.mapper.SysSubjectMapper;
import com.jeff_code.estudy.teacher.service.SysSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SysSubjectServiceImpl implements SysSubjectService {

    @Autowired
    private SysSubjectMapper sysSubjectMapper;

    @Override
    public List<SysSubject> selectAll() {
        return sysSubjectMapper.selectAll();
    }

    @Override
    public List<SysSubject> selectChild(Integer parentId) {
        Example example = new Example(SysSubject.class);
        example.createCriteria().andEqualTo("parentId",parentId);
        List<SysSubject> sysSubjects = sysSubjectMapper.selectByExample(example);
        return sysSubjects;
    }

    @Override
    public List<SysSubject> selectBroth(Integer subjectId) {
        SysSubject sysSubject = sysSubjectMapper.selectByPrimaryKey(subjectId);
        return selectChild(sysSubject.getParentId());
    }
}
