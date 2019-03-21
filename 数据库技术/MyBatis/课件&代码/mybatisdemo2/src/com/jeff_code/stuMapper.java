package com.jeff_code;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface stuMapper {
    stu selectStuById(Integer id);
    stu selectStuByIdAndName(@Param("id") Integer id, @Param("name") String sname);

    Integer inserStu(stu Stu);

    Integer updateStu(stu Stu);

    Boolean deleteStu(Integer id);

    List<stu> selectAllStus();

    public Map<String,Object> selectEmployeeByIdReturnMap(Integer id );
}
