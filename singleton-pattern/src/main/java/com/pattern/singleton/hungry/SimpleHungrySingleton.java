package com.pattern.singleton.hungry;

/**
 * 懒汉式单例模式
 * 优点：线程安全
 * 缺点：不管是否被使用，单例对象都已经初始化好，比较消耗内存
 * Created by wq on 2019/3/16
 */
public class SimpleHungrySingleton {

    private static final SimpleHungrySingleton sigleton = new SimpleHungrySingleton();

    private SimpleHungrySingleton() {
    }

    public static SimpleHungrySingleton getInstance() {
        return sigleton;
    }
}
