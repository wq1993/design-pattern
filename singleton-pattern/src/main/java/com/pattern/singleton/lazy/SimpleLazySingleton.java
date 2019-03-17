package com.pattern.singleton.lazy;

/**
 * 饿汉式单例模式
 * Created by wq on 2019/3/16
 */
public class SimpleLazySingleton {
    private static SimpleLazySingleton singleton = null;

    private SimpleLazySingleton(){}

    public static SimpleLazySingleton getInstance() {
        if (null == singleton) {
            // 线程1执行到此处进入等待；
            // 线程2进来发现单例还未被实例化，也会执行到此处
            // 无法避免线程安全问题
            singleton = new SimpleLazySingleton();
        }
        return singleton;
    }
}
