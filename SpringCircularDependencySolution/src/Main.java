import java.util.HashMap;
import java.util.Map;

// 模拟 Bean 工厂
class BeanFactory {
    // 一级缓存：存放完整的单例 Bean
    private Map<String, Object> singletonObjects = new HashMap<>();
    // 二级缓存：存放提前暴露的单例 Bean（未完成初始化）
    private Map<String, Object> singletonFactories = new HashMap<>();
    // 三级缓存：存放单例 Bean 的工厂
    private Map<String, ObjectFactory<?>> earlySingletonObjects = new HashMap<>();

    // 获取 Bean 的方法
    public Object getBean(String beanName) {
        // 首先从一级缓存中获取
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject != null) {
            return singletonObject;
        }

        // 从二级缓存中获取
        singletonObject = earlySingletonObjects.get(beanName);
        if (singletonObject != null) {
            // 从二级缓存移除
            earlySingletonObjects.remove(beanName);
            // 放入一级缓存
            singletonObjects.put(beanName, singletonObject);
            return singletonObject;
        }

        // 从三级缓存中获取
        ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
        if (singletonFactory != null) {
            // 获取提前暴露的 Bean
            singletonObject = singletonFactory.getObject();
            // 从三级缓存移除
            singletonFactories.remove(beanName);
            // 放入二级缓存
            earlySingletonObjects.put(beanName, singletonObject);
            // 放入一级缓存
            singletonObjects.put(beanName, singletonObject);
            return singletonObject;
        }

        // 如果都没有，则创建 Bean
        singletonObject = createBean(beanName);
        return singletonObject;
    }

    // 创建 Bean 的方法
    private Object createBean(String beanName) {
        // 创建 Bean 实例
        Object bean = instantiateBean(beanName);
        // 提前暴露 Bean 工厂到三级缓存
        singletonFactories.put(beanName, () -> bean);

        // 填充属性，可能会产生循环依赖
        populateBean(bean);

        // 初始化 Bean
        initializeBean(bean);

        // 从三级缓存移除
        singletonFactories.remove(beanName);
        // 放入一级缓存
        singletonObjects.put(beanName, bean);
        return bean;
    }

    // 实例化 Bean
    private Object instantiateBean(String beanName) {
        // 模拟实例化 Bean
        try {
            Class<?> beanClass = Class.forName(beanName);
            return beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 填充 Bean 属性
    private void populateBean(Object bean) {
        // 模拟填充属性，可能会调用 getBean 产生循环依赖
        // 这里省略具体实现
    }

    // 初始化 Bean
    private void initializeBean(Object bean) {
        // 模拟初始化 Bean
        // 这里省略具体实现
    }
}

// 主类
public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        // 获取 Bean
        Object bean = beanFactory.getBean("com.example.MyBean");
    }
}    