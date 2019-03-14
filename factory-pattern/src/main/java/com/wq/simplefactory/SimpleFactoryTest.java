package com.wq.simplefactory;

import com.wq.RpcProtocol;

/**
 * Created by wq on 2019/3/14
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleProtocolFactory factory = new SimpleProtocolFactory();
        factory.createProtocol("rest").call("hello rest");
        factory.createProtocol(RpcProtocol.class).call("hello rpc");
    }
}
