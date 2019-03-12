package com.bittch.checkstand;

import java.util.HashMap;
import java.util.Map;
/**
 * Author:lorrie
 * Create:2019/1/11
 */
public class Order {

    private  int  orderId=0;

    private int count;
    private final Map<Integer,Integer> orderInfo=new HashMap<>();

    public Order(int orderId, int count) {
        this.orderId=orderId;
        this.count=count;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //

    public Order(int orderId) {
        this.orderId = orderId;

    }

    public int getOrderId() {
        return orderId;
    }
    public Map<Integer, Integer> getOrderInfo() {
        return this.orderInfo;
    }

    //往订单里添加商品
    public void add(int goodsId,Integer count){
        Integer sum = this.orderInfo.get(goodsId);
        if (sum == null) {
            sum = count;
        } else {
            sum += count;
        }
        this.orderInfo.put(goodsId, sum);
        OrderDAO orderDAO=new OrderDAO();
        if(orderDAO.searchOrder(orderId)!=null){

            orderDAO.updateOrder(goodsId,count);
        }
    }
    public void cancel(Integer goodsId,Integer count) {
        Integer sum = this.orderInfo.get(goodsId);
        if (sum != null) {
            sum -= count;
            sum = sum < 0 ? 0 : sum;
            if (sum > 0) {
                this.orderInfo.put(goodsId, sum);
            } else {
                this.orderInfo.remove(goodsId);
            }
        }
        OrderDAO orderDAO=new OrderDAO();
        if(orderDAO.searchOrder(orderId)!=null){

            orderDAO.updateOrder(goodsId,count);
        }
    }
    public void clear(){
        orderInfo.clear();
    }
}
