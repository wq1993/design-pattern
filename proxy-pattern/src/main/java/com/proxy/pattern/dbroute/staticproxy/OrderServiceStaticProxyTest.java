package com.proxy.pattern.dbroute.staticproxy;

import com.proxy.pattern.dbroute.IOrderService;
import com.proxy.pattern.dbroute.Order;
import com.proxy.pattern.dbroute.OrderServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wq on 2019/3/19
 */
public class OrderServiceStaticProxyTest {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Order order = new Order();
//        order.setCreateTime(new Date().getTime());
        Date date = null;
        try {
            date = sdf.parse("2018-11-11");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setCreateTime(date.getTime());

        IOrderService orderService = new OrderServiceStaticProxy(new OrderServiceImpl());
        orderService.createOrder(order);
    }
}
