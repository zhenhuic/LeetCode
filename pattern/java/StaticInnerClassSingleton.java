/**
 * 静态内部类
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {}

    public static StaticInnerClassSingleton getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public void function() {
    }
}
