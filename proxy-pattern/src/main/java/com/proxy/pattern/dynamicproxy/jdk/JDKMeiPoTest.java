package com.proxy.pattern.dynamicproxy.jdk;

import com.proxy.pattern.Person;
import com.proxy.pattern.dynamicproxy.gpedu.GPMeiPo;

/**
 * Created by wq on 2019/3/20
 */
public class JDKMeiPoTest {
    public static void main(String[] args) {
        try {
            // 获取代理对象
            Person proxy = (Person) new GPMeiPo().getInstance(new Girl());
            proxy.findLover();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
