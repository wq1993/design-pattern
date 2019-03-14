package com.wq.factorymethod;

/**
 * Created by wq on 2019/3/14
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        IProtocolFactory restFactory = new RestProtocolFactory();
        restFactory.createProtocol().call("hello rest");
        IProtocolFactory rpcFactory = new RpcProtocolFactory();
        rpcFactory.createProtocol().call("hello rpc");
    }
}
