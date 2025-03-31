package src;

import src.SmsServiceImpl;
import src.SmsStaticProxy;

public class Main {
    public static void main(String[] args) {

        // 静态代理
        /**
         * 我们首先有一个接口 接口定义了方法
         * 然后有一个接口实现类 重写了方法
         * 然后我们要对这个方法前后进行改造
         * 我们需要一个代理类
         * 首先这个代理类 实现了接口 所以他要重写方法  我们可以加上逻辑
         * 在代理类里面创建接口实现类的全局变量 再调用接口实现类的重写方法 就实现了代理
         */
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsStaticProxy smsStaticProxy = new SmsStaticProxy(smsService);
        smsStaticProxy.send("静态代理");

        System.out.println("-----------------------------------------");

        // 动态代理 JDK
        /**
         * JdkProxyFactory类是创建代理对象的
         * 通过Proxy 类的 newProxyInstance() 创建的代理对象在调用方法的时候，
         * 实际会调用到实现InvocationHandler 接口的类的 invoke()方法。
         * 你可以在 invoke() 方法中自定义处理逻辑，比如在方法执行前后做什么事情。
         */
        SmsService smsService2 = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService2.send("动态代理");
    }
}