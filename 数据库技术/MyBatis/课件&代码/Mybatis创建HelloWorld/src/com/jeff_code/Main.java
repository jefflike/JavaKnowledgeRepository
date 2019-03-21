package com.jeff_code;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        // 第三步，创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 第四步，创建MyBatis的SQL(Mapper)映射文件
            StuMapper s  =
                    session.getMapper(StuMapper.class);
            stu stu = s.selectStuById(7);
            System.out.println(stu);
        } finally {
            session.close();
        }
    }
}
