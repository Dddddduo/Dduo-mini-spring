package com.example.minispringday1;

import com.example.minispringday1.bean.UserService;
import org.junit.Test;

public class MiniSpringDay1ApplicationTests {

    @Test
    public void test_BeanFactory(){

        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2.注入bean
        // 传入的是一个object对象 BeanDefinition 
        // 通过构造方法 把UserService对象挂载到成员属性bean上 类BeanDefinition类的成员属性bean是一个Object类型的变量
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());

        // 3.把刚才注册的bean放到BeanFactory里面
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        // Beanfactory里面放主要是一个map 放的是<String,BeanDefinition>
        // 我们这边所做的是将Beanfactory里面的bean拿出来
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
