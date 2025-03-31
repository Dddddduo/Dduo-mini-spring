package org.example;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 自定义MethodInterceptor
 */
public class DebugMethodInterceptor implements MethodInterceptor {


    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    // 拦截被代理类中的方法

    /**
     * 重写的MethodInterceptor父类的intercept方法
     * @param o 被代理的对象 需要增强的对象
     * @param method 被拦截的方法 需要增强的方法
     * @param args 方法入参
     * @param methodProxy 用于调用原始方法
     * @return
     * @throws Throwable
     */

    // 我们使用代理类调用方法时 实际上是调用MethodInterceptor的intercept的方法
    // MethodInterceptor接口的intercept方法
    // 被实现类DebugMethodInterceptor增强 这个类可以自定义
    // 作为参数传到CglibProxyFactory的Enhancer对象里面去
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;
    }

}