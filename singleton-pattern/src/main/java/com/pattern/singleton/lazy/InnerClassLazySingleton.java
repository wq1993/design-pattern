package com.pattern.singleton.lazy;

/**
 * 通过内部类的加载机制，实现懒汉式单例模式
 * Created by wq on 2019/3/16
 */
public class InnerClassLazySingleton {

    private InnerClassLazySingleton() {
        if (null != LazySingletonHolder.singleton) {
            throw new RuntimeException("无法通过反射构造实例");
        }
    }

    // static 是为了使单例的空间共享
    // final 保证这个方法不会被重写，重载
    public static final InnerClassLazySingleton getInstance() {
        return LazySingletonHolder.singleton;
    }

    // 静态内部类不会随着外部类的实例化而加载
    // 而是在被调用时才会加载，而且只加载一次
    // 通过JVM的类加载机制实现了线程安全的单例模式
    // 可能被反射破坏
    private static class LazySingletonHolder {
        private static final InnerClassLazySingleton singleton = new InnerClassLazySingleton();
    }
}
