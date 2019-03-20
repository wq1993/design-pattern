package com.proxy.pattern.dynamicproxy.gpedu;

import java.lang.reflect.Method;

/**
 * Created by wq on 2019/3/20
 */
public interface GPInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
