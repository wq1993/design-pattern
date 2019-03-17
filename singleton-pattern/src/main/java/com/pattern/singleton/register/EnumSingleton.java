package com.pattern.singleton.register;

/**
 * 枚举实现注册式单例模式
 * 能避免序列化破坏单例
 * Created by wq on 2019/3/17
 */
public enum  EnumSingleton {

    INSTANCE;

    private Object data;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
