package com.pattern.singleton;

import com.pattern.singleton.register.ContainerSingleton;

/**
 * Created by wq on 2019/3/17
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object bean = ContainerSingleton.getBean("com.pattern.singleton.InnerClassLoadOrder");
        System.out.println(bean);
    }
}
