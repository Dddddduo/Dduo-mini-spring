package org.example.minispringhelloworld.dao;

import org.example.minispringhelloworld.pojo.User;

import java.util.Collections;
import java.util.List;

/**
 * @author pdai
 */
public class UserDaoImpl {

    /**
     * init.
     */
    public UserDaoImpl() {
    }

    /**
     * mocked to find user list.
     * 返回的是mock数据
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("pdai", 18));
    }
}