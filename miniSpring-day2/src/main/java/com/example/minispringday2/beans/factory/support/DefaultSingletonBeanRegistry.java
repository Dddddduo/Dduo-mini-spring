package com.example.minispringday2.beans.factory.support;

import com.example.minispringday2.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认的单例Bean注册表
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 用HashMap存放bean
    private final Map<String, Object> singletonObjects = new HashMap<>();

    // 添加单体对象
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    // 重写接口中的获取单例对象的方法
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

}
