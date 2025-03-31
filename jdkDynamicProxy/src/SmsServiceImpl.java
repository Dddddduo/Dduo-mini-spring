package src;

public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("发送短信:"+message);
        return message;
    }
}
