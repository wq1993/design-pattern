package com.wq.factorymethod;

import com.wq.IProtocol;
import com.wq.RpcProtocol;

/**
 * Created by wq on 2019/3/14
 */
public class RpcProtocolFactory implements IProtocolFactory {
    public IProtocol createProtocol() {
        return new RpcProtocol();
    }
}
