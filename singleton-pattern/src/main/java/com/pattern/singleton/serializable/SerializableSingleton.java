package com.pattern.singleton.serializable;

import java.io.Serializable;

/**
 * 序列号单例模式
 * Created by wq on 2019/3/17
 */
public class SerializableSingleton implements Serializable {

    private static final SerializableSingleton singleton = new SerializableSingleton();

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return singleton;
    }

    /**
     * 解决序列化导致单例被破坏
     *
     * @return Object
     */
    private Object readResolve() {
        return singleton;
    }
}
