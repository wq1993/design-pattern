package com.wq.abstractfactory;

/**
 * Created by wq on 2019/3/14
 */
public class RestResponse implements IResponse {
    public void waitResponse() {
        System.out.println("接收到rest请求响应");
    }
}
