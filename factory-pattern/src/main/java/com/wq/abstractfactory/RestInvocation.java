package com.wq.abstractfactory;

/**
 * Created by wq on 2019/3/14
 */
public class RestInvocation implements IInvocation {
    public void invoke() {
        System.out.println("通过rest协议发起调用");
    }
}
