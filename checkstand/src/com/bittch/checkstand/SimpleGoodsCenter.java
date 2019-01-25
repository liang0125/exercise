package com.bittch.checkstand;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public class SimpleGoodsCenter implements GoodsCenter {

    private final Map<String, Goods>goodsMap=new HashMap<>();
    //文件存储路径
    private String path=System.getProperty("user.dir")+File.separator+"goods.txt";
    @Override
    public void addGoods(Goods goodsInfo) {
        this.goodsMap.put(goodsInfo.getId(),goodsInfo);
    }

    @Override
    public void removeGoods(String id) {
        this.goodsMap.remove(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        if(this.goodsMap.containsKey(goods.getId())){
            this.goodsMap.put(goods.getId(),goods);
        }
    }

    @Override
    public boolean isExistGoods(String id) {
        if(this.goodsMap.containsKey(id)){
            return true;
        }
        return false;
    }

    @Override
    public Goods getGoods(String goodsId) {
        return this.goodsMap.get(goodsId);
    }

    @Override
    public String listGoods() {
        StringBuilder sb=new StringBuilder();
        sb.append("*************商品信息************\n");
        sb.append("\t\t商品编号\t商品名称\t商品价格\n");
        for(Map.Entry<String,Goods> entry:this.goodsMap.entrySet()){

           Goods goods=entry.getValue();
           sb.append(String.format("\t\t%s\t%s\t%.2f\n",goods.getId(),goods.getName(),goods.getPrice()));
        }
        sb.append("***********************************\n");
        return sb.toString();
    }

    @Override
    public void store() {
        //保存信息到文件
        File file=new File(path);
        try (BufferedWriter Writer = new BufferedWriter(new FileWriter(file))) {
            for(Map.Entry<String,Goods> entry:goodsMap.entrySet()){
                Goods goods=entry.getValue();
                Writer.write(String.format("%s:%s:%.2f",goods.getId(),goods.getName(),goods.getPrice()));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void load() {
        File file=new File(path);
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            for(Map.Entry<String,Goods> entry:this.goodsMap.entrySet()){
                String line;
                while((line=reader.readLine())!=null) {
                    String[] st = line.split(":");
                    if (st.length == 3) {
                        Goods goods = new Goods(st[0], st[1], Double.parseDouble(st[2]));
                        this.addGoods(goods);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
