package com.proxy.pattern.staticproxy;

/**
 * Created by wq on 2019/3/19
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Father father = new Father(new Son());
        father.findLover();
    }
}
