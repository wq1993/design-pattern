package com.proxy.pattern.dynamicproxy.gpedu;

import java.lang.reflect.Method;

/**
 * Created by wq on 2019/3/20
 */
public class GPMeiPo implements GPInvocationHandler {

    // 目标对象
    private Object target;

    /**
     * 生成代理对象
     *
     * @param object 目标对象
     * @return 代理对象
     */
    public Object getInstance(Object object) {
        this.target = object;
        Class<?> clazz = target.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target, args);
        after();
        return object;
    }

    private void before() {
        System.out.println("媒婆已经知道了你的需求");
        System.out.println("正在物色中");
    }

    private void after() {
        System.out.println("找到了，如果你满意，那就准备办事！");
    }
}
