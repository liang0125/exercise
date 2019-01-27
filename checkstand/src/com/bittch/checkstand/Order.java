package com.bittch.checkstand;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public class Order {

    public Order(String orderId) {
        this.orderId = orderId;
    }

    private final String orderId;

    private final Map<String,Integer> orderInfo=new HashMap<>();

    public String getOrderId() {
        return orderId;
    }
    public Map<String, Integer> getOrderInfo() {
        return this.orderInfo;
    }
    public void add(String goodsId,Integer count){
        Integer sum = this.orderInfo.get(goodsId);
        if (sum == null) {
            sum = count;
        } else {
            sum += count;
        }
        this.orderInfo.put(goodsId, sum);
    }
    public void cancel(String goodsId,Integer count) {
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
    }
    public void clear(){
        orderInfo.clear();
    }
}
