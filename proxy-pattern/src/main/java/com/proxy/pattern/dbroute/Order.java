package com.proxy.pattern.dbroute;

/**
 * Created by wq on 2019/3/19
 */
public class Order {
    private Object orderInfo;
    // 假设订单按照生成时间进行分库分表
    private long createTime;
    private String id;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
