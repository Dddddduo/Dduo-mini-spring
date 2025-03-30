package com.example.minispringday1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// BeanFactory是Spring框架中的核心组件之一，用于管理和创建Bean对象
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // 用于获取指定的Bean
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    // 用于注册Bean的定义信息
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}