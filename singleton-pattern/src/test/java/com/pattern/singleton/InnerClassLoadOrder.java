package com.pattern.singleton;

/**
 * Created by wq on 2019/3/16
 */
public class InnerClassLoadOrder {

    public InnerClassLoadOrder() {
        System.out.println("外部类实例化：" + System.currentTimeMillis());
    }

    static {
        System.out.println("外部类静态代码块加载： " + System.currentTimeMillis());
    }

    public static void outMethod() {
        System.out.println("外部类静态方法执行： " + System.currentTimeMillis());
        InnerHolder.innerMethod();
    }

    static class InnerHolder {
        public static void innerMethod() {
            System.out.println("静态内部类方法执行：" + System.currentTimeMillis());
        }
    }
}
