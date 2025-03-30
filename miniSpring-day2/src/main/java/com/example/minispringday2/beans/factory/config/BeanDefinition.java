package com.example.minispringday2.beans.factory.config;

/**
 * 封装一个已经实例化的Bean对象
 * 把对象封装成Bean对象
 * 记录bean的信息 bean的身份证
 */
public class BeanDefinition {

    // 我们这边是将Object换成了Class 单例模式
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

}
