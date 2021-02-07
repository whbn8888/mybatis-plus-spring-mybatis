package cn.itcast.mp.simple;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class TestMybatis {


    @Test
    public void testFindAll() throws Exception {
        //mybatis基本环境
        //1.定义mybatis_config.xml文件地址
        String resource = "mybatis-config.xml";
        //2,获取inputStreamReaderIo流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //3.获取SQLSessionFactory
        SqlSessionFactory sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder().build(inputStream);
        //4.获取Session
        SqlSession sqlSession = sqlSessionFactoryBuilder.openSession();
        //5.操作Mapper接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //测试查询
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
