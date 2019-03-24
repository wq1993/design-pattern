package com.proxy.pattern.dynamicproxy.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wq on 2019/3/24
 */
public class CglibMeiPo implements MethodInterceptor {

    public Object getProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object proxy = methodProxy.invokeSuper(o, objects);
        after();
        return proxy;
    }

    private void before(){
        System.out.println("媒婆已经知道了你的需求");
        System.out.println("正在物色中");
    }

    private void after(){
        System.out.println("找到了，如果你满意，那就准备办事！");
    }
}
