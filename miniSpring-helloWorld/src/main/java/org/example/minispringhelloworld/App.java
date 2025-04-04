package org.example.minispringhelloworld;

import org.example.minispringhelloworld.pojo.User;
import org.example.minispringhelloworld.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    /**
     * main interfaces.
     *
     * @param args args
     */
    public static void main(String[] args) {
        // create and configure beans

        // 往Spring的上下文里面注入bean
        ApplicationContext context =
                new ClassPathXmlApplicationContext("aspects.xml", "daos.xml", "services.xml");

        // retrieve configured instance
        // 实例化对象
        UserServiceImpl service = context.getBean("userService", UserServiceImpl.class);

        // use configured instance
        // 调用service层的方法
        List<User> userList = service.findUserList();

        // print info from beans
        // 使用bean去调用一些方法
        userList.forEach(a -> System.out.println(a.getName() + "," + a.getAge()));
    }
}
