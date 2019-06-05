package net.wanho.test;

import net.wanho.mapper.UserMapper;
import net.wanho.pojo.User;
import net.wanho.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class TestMybatis {

    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void before(){

//        InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//
//        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
//
//        //创建会话
//        sqlSession = sf.openSession();
        session = MybatisUtil.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }


    @Test
    public void testAddUser(){
        User user = new User(null,"hahaha","asdasd");
        /*session.update("net.wanho.mapper.UserMapper.addUser",user);
        session.commit();*/
        userMapper.addUser(user);
        MybatisUtil.closeSession();
    }

    @Test
    public void testDeleteUser(){
        /*sqlSession.update("net.wanho.mapper.UserMapper.deleteUser",4);
        sqlSession.commit();
        sqlSession.close();*/

/*        session.update("net.wanho.mapper.UserMapper.deleteUser",4);
        session.commit();*/
        userMapper.deleteUser(4);
        MybatisUtil.closeSession();
    }

    @Test
    public void testUpdateUser(){
        User user = new User(5,"qwerrrrr","qwe123");
        /*session.update("net.wanho.mapper.UserMapper.updateUser",user);
        session.commit();*/

        userMapper.updateUser(user);
        MybatisUtil.closeSession();
    }

    @Test
    public void testGetAllUsers(){
        List<User> users = userMapper.getAllUsers();
        MybatisUtil.closeSession();
        System.out.println(users);
    }

    @Test
    public void testGetUserById(){
        User user = session.selectOne("net.wanho.mapper.UserMapper.getUserById",1);
        MybatisUtil.closeSession();
        System.out.println(user);
    }


    @Test
    public void testGetUserByName(){
//        List<User> userList= userMapper.getUserByName("%x%");
        List<User> userList= userMapper.getUserByName("x");
        MybatisUtil.closeSession();
        System.out.println(userList);
    }


    @Test
    public void testAddUserReturnKey(){
        User user = new User(null,"hahaha","asdasd");
        userMapper.addUserReturnKey(user);
        session.commit();
        System.out.println(user.getId());
        MybatisUtil.closeSession();
    }

    @Test
    public void testUpdateUserById(){
        User user = new User(2,"hehehehehe","hehe123");
        userMapper.updateUserById(2,"hehehehehe","123321");
        session.commit();
        System.out.println(user.getId());
        MybatisUtil.closeSession();
    }
}
