package net.wanho.mapper;

import net.wanho.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface UserMapper {

    void addUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id);

    List<User> getUserByName(String name);

    void addUserReturnKey(User user);

    void addUserReturnKey2(User user);

    void updateUserById(Integer id,String name,String password);

}
