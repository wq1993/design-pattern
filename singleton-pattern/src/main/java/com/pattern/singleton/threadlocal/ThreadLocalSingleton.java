package com.pattern.singleton.threadlocal;

/**
 * 通过线程局部变量ThreadLocal实现局部线程安全单例模式
 * 线程内安全，线程间不安全
 * Created by wq on 2019/3/17
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> LOCAL = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return LOCAL.get();
    }
}
