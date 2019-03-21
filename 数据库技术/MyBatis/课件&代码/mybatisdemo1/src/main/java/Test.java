import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: jefflike
 * @create: 2018/9/7
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            // 第四步，创建MyBatis的SQL(Mapper)映射文件
            StuMapper s  =
                    session.getMapper(StuMapper.class);
            stu stu = s.selectStuById(5);
            System.out.println(stu);
        } finally {
            session.close();
        }
    }
}
