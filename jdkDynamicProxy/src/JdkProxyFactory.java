package src;

import java.lang.reflect.Proxy;

// 获取代理对象的工厂类
public class JdkProxyFactory {
    public static Object getProxy(Object target){

        /**
         * 这个方法主要是用来生成一个代理对象
         * param1: loader :类加载器，用于加载代理对象。
         * param2: 被代理类实现的一些接口
         * param3: 实现了InvocationHandler接口的对象；
         */
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 获取目标的类加载器
                target.getClass().getInterfaces(),  // 代理需要实现的接口
                new DebugInvocationHandler(target)  // 代理对象对应的自定义 DebugInvocationHandler
        );

    }
}
