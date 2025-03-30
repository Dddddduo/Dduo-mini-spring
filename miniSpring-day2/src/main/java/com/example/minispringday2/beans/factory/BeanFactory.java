package com.example.minispringday2.beans.factory;


import com.example.minispringday2.beans.BeansException;

/**
 * Bean工厂
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
