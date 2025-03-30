package com.example.minispringday1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// BeanFactory是Spring框架中的核心组件之一，用于管理和创建Bean对象
public class BeanFactory {

    // 创建一个ConcurrentHashMap
    // 其中key是String类型的 代表的是bean的名称
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