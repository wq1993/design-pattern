package com.pattern.singleton.lazy;

/**
 * 加锁实现线程安全懒汉式单例
 * Created by wq on 2019/3/16
 */
public class SyncLazySingleton {

    private static SyncLazySingleton singleton = null;

    private SyncLazySingleton(){}

    // 加上synchronized关键字，当一个线程获取到锁，进入方法时，其他线程会在外等待，直到获取锁的线程执行完该方法
    // 但是，synchronized加在方法上，锁的力度太大，性能比较低
    /*public synchronized static SyncLazySingleton getInstance() {
        if (null == singleton) {
            singleton = new SyncLazySingleton();
        }
        return singleton;
    }*/

    // 双重检查，减小了锁的力度，但性能仍然有待提升。
    public static SyncLazySingleton getInstance() {
        // 第一个if用来判断，当单例对象已经实例化时，直接返回，避免获取到锁后再判断，优化性能
        if (null == singleton) {
            synchronized (SyncLazySingleton.class) {
                if (null == singleton) {
                    // 第二个if为了实现线程安全
                    // 当第二个线程获取到锁时，发现单例对象已经实例化，不会再执行后面代码
                    singleton = new SyncLazySingleton();
                }
            }
        }
        return singleton;
    }
}
