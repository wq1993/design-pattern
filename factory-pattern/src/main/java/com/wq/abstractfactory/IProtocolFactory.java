package com.wq.abstractfactory;

import com.wq.IProtocol;

/**
 * Created by wq on 2019/3/14
 */
public interface IProtocolFactory {

    IProtocol createProtocol();

    IInvocation createInvocation();

    IResponse createResponse();
}
