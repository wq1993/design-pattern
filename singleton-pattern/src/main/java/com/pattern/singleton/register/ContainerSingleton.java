package com.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例模式
 * Created by wq on 2019/3/17
 */
public class ContainerSingleton {
    /**
     * 容器，ConcurrentHashMap只保证自己线程安全
     */
    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    private ContainerSingleton() {
    }

    /**
     * getBean
     * 线程安全需要同步锁synchronized实现
     *
     * @param className className
     * @return Object
     */
    public static Object getBean(String className) {
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object instance = null;
                try {
                    instance = Class.forName(className).newInstance();
                    ioc.put(className, instance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return instance;
            }
        }
        return null;
    }
}
