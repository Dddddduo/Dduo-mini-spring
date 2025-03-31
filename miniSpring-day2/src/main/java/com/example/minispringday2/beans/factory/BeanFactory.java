package com.example.minispringday2.beans.factory;


import com.example.minispringday2.beans.BeansException;

/**
 * Bean工厂
 * 这个接口定义的事获取bean的规则
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
