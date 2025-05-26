public class Main { }

// 单例模式 初始化bean

// 饿汉式 单例初始化
// 在类首次加载时就进行初始化 不需要考虑线程安全问题
class  Hungrybean{
    private static final Hungrybean INSTANCE = new Hungrybean();
    public static Hungrybean getInstance() {
        return INSTANCE;
    }
}

// 懒汉式 单例初始化
// 在使用时再进行初始化 可能存在线程安全问题
class  Lazybean{
    private static Lazybean INSTANCE ;
    public static Lazybean getInstance() {
        if(INSTANCE==null){
            INSTANCE=new Lazybean();
        }
        return INSTANCE;
    }
}

// 锁机制 修复了懒汉是的线程安全问题
class ThreadSafeLazybean{
    private static ThreadSafeLazybean INSTANCE;
    public static ThreadSafeLazybean getInstance(){
        if(INSTANCE==null){
            synchronized (ThreadSafeLazybean.class){
                if (INSTANCE==null){
                    INSTANCE=new ThreadSafeLazybean();
                }
                return INSTANCE;
            }
        }
    }
}