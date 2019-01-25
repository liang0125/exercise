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

    private final Map<String,Integer> goodsInfo=new HashMap<>();

    public String getOrderId() {
        return orderId;
    }
    public Map<String, Integer> getOrderInfo() {
        return this.goodsInfo;
    }
    public void add(String goodsId,Integer count){
        int sum;
        if(goodsInfo.containsKey(goodsId)){
            sum=goodsInfo.get(goodsId)+count;
        }
        else {
            sum=count;
        }
        goodsInfo.put(goodsId,count);
    }
    public void cancel(String goodsId,Integer count){
        int sum;
        if(goodsInfo.containsKey(goodsId)){
            sum=goodsInfo.get(goodsId)-count;
            sum=sum<0?0:sum;
        }
        else {
            System.out.println("请输入存在的商品编号");
        }
        goodsInfo.put(goodsId,count);
    }
    public void clear(){
        goodsInfo.clear();
    }
}
