package com.wq;

/**
 * Created by wq on 2019/3/14
 */
public class RestProtocol implements IProtocol {
    public void call(String command) {
        System.out.println("通过Rest协议执行: " + command);
    }
}
