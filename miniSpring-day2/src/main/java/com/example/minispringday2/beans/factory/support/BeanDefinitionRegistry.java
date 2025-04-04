package com.example.minispringday2.beans.factory.support;


import com.example.minispringday2.beans.factory.config.BeanDefinition;

/**
 * 最终类要继承这个接口
 * 规则是bean的注册
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
