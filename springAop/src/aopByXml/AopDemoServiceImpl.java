package aopByXml;

// 目标类 核心业务
public class AopDemoServiceImpl {

    public void doMethod1() {
        System.out.println("aopByXml.AopDemoServiceImpl.doMethod1()");
    }

    public String doMethod2() {
        System.out.println("aopByXml.AopDemoServiceImpl.doMethod2()");
        return "hello world";
    }

    public String doMethod3() throws Exception {
        System.out.println("aopByXml.AopDemoServiceImpl.doMethod3()");
        throw new Exception("some exception");
    }
}
