package com.pattern.singleton;

import com.pattern.singleton.lazy.InnerClassLazySingleton;
import com.pattern.singleton.lazy.SimpleLazySingleton;
import com.pattern.singleton.lazy.SyncLazySingleton;
import com.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * Created by wq on 2019/3/16
 */
public class ExecutorThread implements Runnable {
    public void run() {
//		SimpleHungrySingleton singleton = SimpleHungrySingleton.getInstance();
//        SimpleLazySingleton singleton = SimpleLazySingleton.getInstance();
//        SyncLazySingleton singleton = SyncLazySingleton.getInstance();
//        InnerClassLazySingleton singleton = InnerClassLazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
//        System.out.println(singleton);
    }
}
