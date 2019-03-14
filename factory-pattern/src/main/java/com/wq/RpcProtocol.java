package com.wq;

/**
 * Created by wq on 2019/3/14
 */
public class RpcProtocol implements IProtocol {
    public void call(String command) {
        System.out.println("通过Rpc协议执行: " + command);
    }
}
