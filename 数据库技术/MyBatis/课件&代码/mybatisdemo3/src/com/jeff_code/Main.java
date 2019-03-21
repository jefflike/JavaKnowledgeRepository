package com.jeff_code;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // 第三步，创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        try {
            empMapper mapper1 = session.getMapper(empMapper.class);
            emp empIns = new emp();
            empIns.setId(1);
            empIns.setAge(90);
            emp emp1 = mapper1.selectEmpByPojo(empIns);
            System.out.println(emp1);

            Map<String, Object> map = new HashMap<>();
            map.put("mapId", 2);
            map.put("mapAge", 50);
            emp emp2 = mapper1.selectEmpByMap(map);
            System.out.println(emp2);

            Map<String, emp> stringObjectMap = mapper1.selectEmpInMap(3);
            System.out.println(stringObjectMap);

            Map<String, emp> stringempMap = mapper1.selectEmpReturnMap();
            System.out.println(stringempMap);


/*            stuMapperDynamicSql mapper = session.getMapper(stuMapperDynamicSql.class);
            stu condition = new stu();
//            condition.setId(1);
            condition.setSname("张三");
//            condition.setAddr("山里");

            List<stu> stus = mapper.selectStuByConditionTrim(condition);
            System.out.println(stus);*/
        } finally {
            session.close();
        }


//        try {
//            // 第四步，创建MyBatis的SQL(Mapper)映射文件
//            stuMapper s  =
//                    session.getMapper(stuMapper.class);
//            stu NewStu = new stu(null, "meinv", "where");
//            Integer i = s.inserStu(NewStu);
//            session.commit();
//            System.out.println(i);
//            System.out.println(NewStu.getId());
//            stu stu = s.selectStuByIdAndName(14, "like");
//            System.out.println(stu);
//            List<stu> stus = s.selectAllStus();
//            for(stu st : stus){
//                System.out.println(st);

//            }
//        } finally {
//            session.close();
//        }
    }
}

