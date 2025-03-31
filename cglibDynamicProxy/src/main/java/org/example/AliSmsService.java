package org.example;

public class AliSmsService {
    // 发送短信
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}