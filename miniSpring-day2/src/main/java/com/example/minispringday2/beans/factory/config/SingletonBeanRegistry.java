package com.example.minispringday2.beans.factory.config;

/**
 * 这个接口是单例注册表
 */
public interface SingletonBeanRegistry {

    // 接口的规则是获取单例对象
    // 实现这个接口的类必须重写获取单例对象的逻辑

    // 获取单例对象
    Object getSingleton(String beanName);

}
