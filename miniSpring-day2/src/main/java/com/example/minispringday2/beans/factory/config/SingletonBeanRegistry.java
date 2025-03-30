package com.example.minispringday2.beans.factory.config;

/**
 *
 * 单例注册表
 */
public interface SingletonBeanRegistry {

    // 获取单例对象
    Object getSingleton(String beanName);

}
