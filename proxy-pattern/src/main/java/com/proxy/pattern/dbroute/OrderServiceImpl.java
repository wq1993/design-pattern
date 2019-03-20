package com.proxy.pattern.dbroute;

/**
 * Created by wq on 2019/3/19
 */
public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        // 实际应用场景通过spring注解注入，此处方便测试
        this.orderDao = new OrderDao();
    }

    public int createOrder(Order order) {
        return orderDao.insert(order);
    }
}
