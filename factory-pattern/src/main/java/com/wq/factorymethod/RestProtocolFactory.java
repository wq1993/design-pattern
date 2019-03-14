package com.wq.factorymethod;

import com.wq.IProtocol;
import com.wq.RestProtocol;

/**
 * Created by wq on 2019/3/14
 */
public class RestProtocolFactory implements IProtocolFactory {
    public IProtocol createProtocol() {
        return new RestProtocol();
    }
}
