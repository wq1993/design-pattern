package com.pattern.singleton;

import com.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * Created by wq on 2019/3/17
 */
public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        Thread t3 = new Thread(new ExecutorThread());
        t1.start();
        t2.start();
        t3.start();
    }
}
