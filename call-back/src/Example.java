import java.util.ArrayList;
import java.util.List;

// 定义钩子接口
interface Hook {
    void execute();
}

// 主类，包含钩子机制
class HookExample {
    private List<Hook> hooks = new ArrayList<>();

    public void registerHook(Hook hook) {
        hooks.add(hook);
    }

    public void doSomething() {
        System.out.println("正在执行主要操作...");
        // 执行所有注册的钩子
        for (Hook hook : hooks) {
            hook.execute();
        }
    }
}

// 具体的钩子实现类
class MyHook implements Hook {
    @Override
    public void execute() {
        System.out.println("钩子函数被执行了");
    }
}

// 主类
public class Example {
    public static void main(String[] args) {
        HookExample example = new HookExample();
        // 注册钩子
        example.registerHook(new MyHook());
        // 执行主要操作
        example.doSomething();
    }
}