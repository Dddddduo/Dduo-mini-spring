package src;

import java.lang.reflect.Proxy;

// 获取代理对象的工厂类
public class JdkProxyFactory {
    public static Object getProxy(Object target){

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 获取目标的类加载器
                target.getClass().getInterfaces(),  // 代理需要实现的接口
                new DebugInvocationHandler(target)  // 代理对象对应的自定义 DebugInvocationHandler
        );

    }
}
