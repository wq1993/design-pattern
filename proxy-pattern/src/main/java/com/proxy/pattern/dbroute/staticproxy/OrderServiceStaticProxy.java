package com.proxy.pattern.dbroute.staticproxy;

import com.proxy.pattern.dbroute.IOrderService;
import com.proxy.pattern.dbroute.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wq on 2019/3/19
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    public int createOrder(Order order) {
        long createTime = order.getCreateTime();
        int year = Integer.parseInt(sdf.format(new Date(createTime)));
        System.out.println("静态代理类自动将订单自动分配到[DB_" + year + "]数据源处理数据");
        DataSourceContextHolder.setLocal(year);
        int result = this.orderService.createOrder(order);
        DataSourceContextHolder.reStore();
        return result;
    }
}
