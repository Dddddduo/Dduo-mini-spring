package org.example;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {

    /**
     * 这边主要是创建一个Enhancer对象
     * 把被代理类的类加载器 被代理类 还有方法拦截器作为参数传入
     * 其中方法拦截器DebugMethodInterceptor实现了接口MethodInterceptor(方法拦截器)
     * @param clazz
     * @return
     */
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }

}