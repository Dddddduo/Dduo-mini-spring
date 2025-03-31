package src;

// 静态代理
public class SmsStaticProxy implements SmsService{

    private final SmsService smsService;

    public SmsStaticProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        System.out.println("方法调用前");
        smsService.send(message);
        System.out.println("方法调用后");
        return message;
    }
}
