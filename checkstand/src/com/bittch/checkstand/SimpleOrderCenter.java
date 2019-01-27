package com.bittch.checkstand;
import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public class SimpleOrderCenter implements OrderCenter {
    private Map<String,Order> orderMap=new HashMap<>();
    private Order order;
    private GoodsCenter goodsCenter;
    private String path=System.getProperty("user.dir")+File.separator+"orders.txt";

    public SimpleOrderCenter(GoodsCenter goodsCenter) {
        this.goodsCenter = goodsCenter;
    }

    @Override
    public void addOrder(Order order) {
        if(!orderMap.containsKey(order.getOrderId())) {
            this.orderMap.put(order.getOrderId(), order);
        }
        else {
            System.out.println("订单已存在，无法添加！");
        }
    }

    @Override
    public void removeOrder(Order order) {
        if(orderMap.containsKey(order.getOrderId())) {
            this.orderMap.remove(order.getOrderId(), order);
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
        for(Order order:this.orderMap.values()){
                Map<String,Integer> orderInfo=this.order.getOrderInfo();
                double total=0.0;
                for(Map.Entry<String,Integer> entry: orderInfo.entrySet()){
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
        Order order=this.orderMap.get(orderId);
        sb.append("=================订单====================\n");
        sb.append("订单编号："+order.getOrderId()+"\n");
        sb.append("打印时间："+LocalDate.now().toString()+"\n");
        sb.append("========================================\n");
        sb.append("\t\t商品编号\t商品名称\t商品数量\t商品单价\n");
        double total=0.0;
        for(Map.Entry<String,Integer> entry:order.getOrderInfo().entrySet()){
            Goods goods=this.goodsCenter.getGoods(orderId);
            sb.append(String.format("\t\t%s\t%s\t%d\t%.2f\n",goods.getId(),goods.getName(),entry.getValue(),goods.getPrice()));
            total+=entry.getValue()*goods.getPrice();
        }
        sb.append("========================================\n");
        sb.append("总价："+total+"\n");
        sb.append("========================================\n");
        return sb.toString();
    }

    @Override
    public void storeOrders()  {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Order order : this.orderMap.values()) {
                double totalPrice = 0.0D;
                Map<String, Integer> goodMap = order.getOrderInfo();
                for (Map.Entry<String, Integer> entry : goodMap.entrySet()) {
                    String goodId = entry.getKey();
                    Integer count = entry.getValue();
                    Goods goods = goodsCenter.getGoods(goodId);
                    totalPrice += goods.getPrice() * count;
                }
                writer.write(String.format("%s:%.2f", order.getOrderId(), totalPrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadOrders() {
        File file=new File(path);
        if(file.exists()&&file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] st = line.split(":");
                    if (st.length == 2) {
                        String id=st[0];
                        Double totalPrice=Double.parseDouble(st[1]);
                        addOrder(new Order(id));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("请按照格式输入");
        }
    }
}
