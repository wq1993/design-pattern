package com.proxy.pattern.dbroute;

/**
 * Created by wq on 2019/3/19
 */
public class OrderDao {
    public int insert(Order order) {
        System.out.println("创建订单成功");
        return 1;
    }
}
