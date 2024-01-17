package co.shu.util;

import org.apache.ibatis.session.*;
import org.apache.ibatis.io.Resources;
import java.io.InputStream;
import java.io.IOException;

public class MyBatisSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory() {
        if(sqlSessionFactory == null ) {
            InputStream inputStream;

            try {
                // get mybatis configuration from resource folder
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
            catch(IOException e)
            {
                throw new RuntimeException(e.getCause());
            }
        }

        return sqlSessionFactory;
    }

    public static SqlSession openSession() {
        return getSqlSessionFactory().openSession();
    }
}
