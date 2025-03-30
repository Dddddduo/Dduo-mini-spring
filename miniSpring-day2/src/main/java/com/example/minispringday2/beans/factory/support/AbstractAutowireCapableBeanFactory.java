package com.example.minispringday2.beans.factory.support;

import com.example.minispringday2.beans.BeansException;
import com.example.minispringday2.beans.factory.config.BeanDefinition;

/**
 * 创建和管理bean实例
 * 实例化bean
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    // 实例化bean
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 将bean放到缓存里面
        // 存放到单例对象的缓存中去
        addSingleton(beanName, bean);
        return bean;
    }

}
