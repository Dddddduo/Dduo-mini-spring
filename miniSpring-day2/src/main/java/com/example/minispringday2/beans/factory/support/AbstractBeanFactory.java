package com.example.minispringday2.beans.factory.support;

import com.example.minispringday2.beans.BeansException;
import com.example.minispringday2.beans.factory.BeanFactory;
import com.example.minispringday2.beans.factory.config.BeanDefinition;

/**
 * 抽象类 定义模版方法
 * 继承DefaultSingletonBeanRegistry 具备使用单例注册类的方法
 *
 * AbstractBeanFactory 注册表接口
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    // 会检查一下是否获取成功
    // 重写的是对单例 Bean 对象的获取以及在获取不到时需要拿到Bean的定义做相应 Bean 实例化操作
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
