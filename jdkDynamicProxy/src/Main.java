package src;

import src.SmsServiceImpl;
import src.SmsStaticProxy;

public class Main {
    public static void main(String[] args) {
        // 静态代理
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsStaticProxy smsStaticProxy = new SmsStaticProxy(smsService);
        smsStaticProxy.send("静态代理");

        System.out.println("-----------------------------------------");

        // 动态代理
        SmsService smsService2 = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService2.send("动态代理");
    }
}