package com.pattern.singleton;

/**
 * Created by wq on 2019/3/16
 */
public class InnerClassLoadOrderTest {
    public static void main(String[] args) {
        InnerClassLoadOrder classLoadOrder = new InnerClassLoadOrder();
        classLoadOrder.outMethod();
//        InnerClassLoadOrder.outMethod();
    }
}
