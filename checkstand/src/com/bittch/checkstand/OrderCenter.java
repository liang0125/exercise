package com.bittch.checkstand;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public interface OrderCenter {
    void addOrder(Order order);
    void removeOrder(Order order);
    String ordersTable();
    String orderTable(Integer orderId);

}
