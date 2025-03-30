package com.example.minispringday2.beans.factory.support;

import com.example.minispringday2.beans.BeansException;
import com.example.minispringday2.beans.factory.config.BeanDefinition;

/**
 * 创建和管理bean实例
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

}
