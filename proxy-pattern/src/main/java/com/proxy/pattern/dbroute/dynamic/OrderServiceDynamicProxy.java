package com.proxy.pattern.dbroute.dynamic;

import com.proxy.pattern.dbroute.staticproxy.DataSourceContextHolder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wq on 2019/3/19
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    private Object proxyObj;

    public Object getProxy(Object target) {
        this.proxyObj = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke(args[0]);
        Object obj = method.invoke(proxyObj, args);
        afterInvoke();
        return obj;
    }

    private void afterInvoke() {
        System.out.println("Proxy after Invoke");
        DataSourceContextHolder.reStore();
    }


    private void beforeInvoke(Object target) {
        System.out.println("Proxy before Invoke");
        try {
            long createTime = (long) target.getClass().getMethod("getCreateTime").invoke(target);
            int year = Integer.parseInt(sdf.format(new Date(createTime)));
            System.out.println("动态代理类自动将订单自动分配到[DB_" + year + "]数据源处理数据");
            DataSourceContextHolder.setLocal(year);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
