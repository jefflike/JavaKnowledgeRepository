package com.jeff_code.estudy.teacher.service;


import com.jeff_code.estudy.bean.SysSubject;
import java.util.List;

public interface SysSubjectService {
    List<SysSubject> selectAll();

    List<SysSubject> selectChild(Integer parentId);

    List<SysSubject> selectBroth(Integer subjectId);
}
