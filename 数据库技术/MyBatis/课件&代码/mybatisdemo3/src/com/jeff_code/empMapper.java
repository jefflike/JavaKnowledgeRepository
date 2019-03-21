package com.jeff_code;

import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

/**
 * @Author: jefflike
 * @create: 2018/10/16
 * @describe:
 */
public interface empMapper {
    // pojo参数
    emp selectEmpByPojo(emp empInstance);

    // map参数
    emp selectEmpByMap(Map empInstance);

    // 查询一条数据将值返回到一个map中
    // {3={name=令狐冲, deptId=1, id=3, empno=100003, age=24}}
    @MapKey("id")
    Map<String, emp> selectEmpInMap(Integer id);

    // 按照上面的方式将所有的数据查到返回到map，map的key就是我们指定的
    @MapKey("id")
    Map<String, emp> selectEmpReturnMap();
}
