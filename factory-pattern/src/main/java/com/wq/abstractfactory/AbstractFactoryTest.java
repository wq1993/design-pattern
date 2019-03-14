package com.wq.abstractfactory;

/**
 * Created by wq on 2019/3/14
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IProtocolFactory factory = new RestProtocolFactory();
        factory.createInvocation().invoke();
        factory.createProtocol().call("hello rest");
        factory.createResponse().waitResponse();
    }
}
