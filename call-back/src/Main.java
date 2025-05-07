// 定义回调接口
interface CalculationCallback {
    void onCalculationComplete(int result);
}

// 计算器类
class Calculator {
    public void calculate(int a, int b, CalculationCallback callback) {
        int result = a + b;
        // 调用回调方法
        callback.onCalculationComplete(result);
    }
}

// 主类
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // 定义回调接口的实现
        CalculationCallback callback = new CalculationCallback() {
            @Override
            public void onCalculationComplete(int result) {
                System.out.println("计算结果是: " + result);
            }
        };
        // 调用计算方法并传入回调
        calculator.calculate(3, 5, callback);
    }
}