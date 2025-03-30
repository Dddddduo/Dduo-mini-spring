package com.example.minispringday1;

// 封装一个已经实例化的Bean对象
// 把对象封装成bean对象
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}