package com.wq.simplefactory;

import com.wq.IProtocol;
import com.wq.RestProtocol;
import com.wq.RpcProtocol;

/**
 * Created by wq on 2019/3/14
 */
public class SimpleProtocolFactory {

    public IProtocol createProtocol(String protocol) {
        if ("rest".equals(protocol)) {
            return new RestProtocol();
        } else if ("rpc".equals(protocol)) {
            return new RpcProtocol();
        } else {
            return null;
        }
    }

    public IProtocol createProtocol(Class clazz) {
        try {
            if (null != clazz) {
                return (IProtocol) clazz.newInstance();
            }
        } catch (Exception e) {
            // not implement
            System.out.println("未找到协议");
        }
        return null;
    }
}
