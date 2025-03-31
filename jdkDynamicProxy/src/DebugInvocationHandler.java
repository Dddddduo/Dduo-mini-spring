package src;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// jdk的动态代理类
public class DebugInvocationHandler implements InvocationHandler {

    // 这个target是代理类中的真实对象
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * proxy :动态生成的代理类
     * method : 与代理类对象调用的方法相对应
     * args : 当前 method 方法的参数
     *
     * 我们会在这个方法里面调用原生方法
     * invoke() 方法: 当我们的动态代理对象调用原生方法的时候，
     * 最终实际上调用到的是 invoke() 方法，
     * 然后 invoke() 方法代替我们去调用了被代理对象的原生方法。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("方法调用前");
        Object result = method.invoke(target, args);
        System.out.println("方法调用后");
        return result;
    }

}