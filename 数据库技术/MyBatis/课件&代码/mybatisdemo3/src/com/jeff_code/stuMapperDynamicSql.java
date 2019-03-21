package com.jeff_code;

import java.util.List;

public interface stuMapperDynamicSql {
    List<stu> selectStuByConditionIfAndWhere(stu condition);

    List<stu> selectStuByConditionTrim(stu condition);
}
