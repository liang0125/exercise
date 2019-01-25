package com.bittch.checkstand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public class SimpleOrderCenter implements OrderCenter {
    private Map<String,Order>orderInfo=new HashMap<>();
    private Order order;
    private GoodsCenter goodsCenter;
    private String path=System.getProperty("user.dir")+File.separator+"orders.txt";

    public SimpleOrderCenter(GoodsCenter goodsCenter) {
        this.goodsCenter = goodsCenter;
    }

    @Override
    public void addOrder(Order order) {
        if(!orderInfo.containsKey(order.getOrderId())) {
            this.orderInfo.put(order.getOrderId(), order);
        }
        else {
            System.out.println("订单已存在，无法添加！");
        }
    }

    @Override
    public void removeOrder(Order order) {
        if(orderInfo.containsKey(order.getOrderId())) {
            this.orderInfo.remove(order.getOrderId(), order);
        }
        else {
            System.out.println("订单不存在，无法删除！");
        }
    }

    @Override
    public String ordersTable() {
        StringBuilder sb=new StringBuilder();
        sb.append("===================订单信息====================\n");
        sb.append("\t\t订单编号\t总价\n");
        for(Order order:this.orderInfo.values()){
                Map<String,Integer> orderinfo=this.order.getOrderInfo();
                double total=0.0;
                for(Map.Entry<String,Integer> entry: orderinfo.entrySet()){
                    String goodsId=entry.getKey();
                    Integer goodsCount=entry.getValue();
                    Goods goods=goodsCenter.getGoods(goodsId);
                    total+=goods.getPrice()*goodsCount;
                }
            sb.append(String.format("\t\t%s\t%.2f\n",order.getOrderId(),total));
        }
        sb.append("========================================\n");
        return sb.toString();
    }

    @Override
    public String orderTable(String orderId) {
        StringBuilder sb=new StringBuilder();
        Order order=this.orderInfo.get(orderId);
        sb.append("=================订单====================\n");
        sb.append("订单编号："+order.getOrderId()+"\n");
        sb.append("打印时间："+LocalDate.now().toString()+"\n");
        sb.append("========================================\n");
        sb.append("\t\t商品编号\t商品名称\t商品数量\t商品单价\n");
        double total=0.0;
        for(Map.Entry<String,Integer> entry:order.getOrderInfo().entrySet()){
            Goods goods=this.goodsCenter.getGoods(orderId);
            sb.append(String.format("\t\t%s\t%s\t%d\t%.2f",goods.getId(),goods.getName(),entry.getValue(),goods.getPrice()));
            total+=entry.getValue()*goods.getPrice();
        }
        sb.append("========================================\n");
        sb.append("总价："+total+"\n");
        sb.append("========================================\n");
        return sb.toString();
    }

    @Override
    public void storeOrders()  {
        File file=new File(path);
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(file))){
            for(Map.Entry<String,Order> entry:this.orderInfo.entrySet()){
                Order order=entry.getValue();
                writer.write(String.format("%s:%s:%d:%.2f",order.getOrderId(),order.getOrderInfo()));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void loadOrders() {
        System.out.println("加载订单");
    }
}
