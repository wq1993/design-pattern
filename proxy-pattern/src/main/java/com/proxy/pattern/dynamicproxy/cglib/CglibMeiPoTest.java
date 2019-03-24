package com.proxy.pattern.dynamicproxy.cglib;

import com.proxy.pattern.staticproxy.Son;

/**
 * Created by wq on 2019/3/24
 */
public class CglibMeiPoTest {
    public static void main(String[] args) {
        Son proxy = (Son) new CglibMeiPo().getProxy(Son.class);
        proxy.findLover();
    }
}
