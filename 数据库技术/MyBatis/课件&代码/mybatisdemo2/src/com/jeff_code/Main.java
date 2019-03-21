package com.jeff_code;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String resource = "conf/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // 第三步，创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 第四步，创建MyBatis的SQL(Mapper)映射文件
            stuMapper s  =
                    session.getMapper(stuMapper.class);
//            stu NewStu = new stu(null, "meinv", "where");
//            Integer i = s.inserStu(NewStu);
//            session.commit();
//            System.out.println(i);
//            System.out.println(NewStu.getId());
//            stu stu = s.selectStuByIdAndName(14, "like");
//            System.out.println(stu);
            List<stu> stus = s.selectAllStus();
            for(stu st : stus){
                System.out.println(st);
            }
        } finally {
            session.close();
        }
    }
}

