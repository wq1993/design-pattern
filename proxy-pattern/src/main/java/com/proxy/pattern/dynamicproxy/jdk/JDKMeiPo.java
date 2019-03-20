package com.proxy.pattern.dynamicproxy.jdk;

import com.proxy.pattern.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wq on 2019/3/20
 */
public class JDKMeiPo implements InvocationHandler {

    // 目标对象
    private Object target;

    public Object getInstance(Person person) {
        this.target = person;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target, args);
        after();
        return object;
    }

    private void before(){
        System.out.println("媒婆已经知道了你的需求");
        System.out.println("正在物色中");
    }

    private void after(){
        System.out.println("找到了，如果你满意，那就准备办事！");
    }
}
