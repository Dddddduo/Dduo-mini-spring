//
//import org.aspectj.lang.*;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//@Aspect
//public class LogAspect {
//    @Pointcut("execution(public int com.dc.esb.CalculatorImpl.*(..))")
//    public void pointCut() {
//    }
//
//    @Before("pointCut()")
//    public void beforeMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        System.out.println("Logger-->前置通知，方法名：" + methodName + "，参数：" + args);
//    }
//
//    @After("execution(public int com.dc.esb.CalculatorImpl.*(..))")
//    public void afterMethod(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("Logger-->后置通知，方法名：" + methodName);
//    }
//
//    @AfterReturning(value = "execution(public int com.dc.esb.CalculatorImpl.*(..))", returning = "result")
//    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("Logger-->返回通知，方法名：" + methodName + "，结果：" + result);
//    }
//
//    @AfterThrowing(value = "execution(public int com.dc.esb.CalculatorImpl.*(..))", throwing = "ex")
//    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
//        String methodName = joinPoint.getSignature().getName();
//        System.out.println("Logger-->异常通知，方法名：" + methodName + "，异常：" + ex);
//    }
//
//    @Around("execution(public int com.dc.esb.CalculatorImpl.*(..))")
//    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//        Object result = null;
//        try {
//            System.out.println("环绕通知-->目标对象方法执行之前");
//            //目标对象（连接点）方法的执行
//            result = joinPoint.proceed();
//            System.out.println("环绕通知-->目标对象方法返回值之后");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            System.out.println("环绕通知-->目标对象方法出现异常时");
//        } finally {
//            System.out.println("环绕通知-->目标对象方法执行完毕");
//        }
//        return result;
//    }
//}