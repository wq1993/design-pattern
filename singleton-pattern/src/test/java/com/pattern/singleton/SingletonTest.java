package com.pattern.singleton;

/**
 * Created by wq on 2019/3/16
 */
public class SingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();
        System.out.println("===============================");
    }
}
