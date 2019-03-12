package com.bittch.checkstand;

import java.io.*;
import java.util.*;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public class SimpleGoodsCenter implements GoodsCenter {

    private final Map<String, Goods>goodsMap=new HashMap<>();
    //文件存储路径
    private static String path=System.getProperty("user.dir")+File.separator+"goods.txt";
    @Override
    public void addGoods(Goods goodsInfo) {
       this.goodsMap.put(String.valueOf(goodsInfo.getId()),goodsInfo);
        GoodsDAO goodsDAO=new GoodsDAO();
        goodsDAO.add(goodsInfo.getId(),goodsInfo.getName(),goodsInfo.getPrice());
    }

    @Override
    public void removeGoods(int id) {
        this.goodsMap.remove(id);
        GoodsDAO goodsDAO=new GoodsDAO();
        goodsDAO.delete(id);
    }

    @Override
    public void updateGoods(Goods goods) {
        if(this.goodsMap.containsKey(goods.getId())){
            this.goodsMap.put(String.valueOf(goods.getId()),goods);
        }
        GoodsDAO goodsDAO=new GoodsDAO();
        if(goodsDAO.search(goods.getId())!=null){
            goodsDAO.delete(goods.getId());
            goodsDAO.add(goods.getId(),goods.getName(),goods.getPrice());
        }
        else {
            System.out.println("该商品不存在");
        }
    }

    @Override
    public boolean isExistGoods(int id) {
        GoodsDAO goodsDAO=new GoodsDAO();
        if(goodsDAO.search(id)!=null){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Goods getGoods(int goodsId) {
        GoodsDAO goodsDAO=new GoodsDAO();
        return goodsDAO.search(goodsId);
    }

    @Override
    public String listGoods() {
        StringBuilder sb=new StringBuilder();
        sb.append("*************商品信息************\n");
        sb.append("\t\t商品编号\t商品名称\t商品价格\n");
        GoodsDAO goodsDAO=new GoodsDAO();
        if(goodsDAO.searchAll()!=null){
            List<Goods> list=goodsDAO.searchAll();
            Iterator<Goods> iterator=list.iterator();
            while (iterator.hasNext()){
                Goods goods=iterator.next();
                sb.append(String.format("\t\t%s\t%s\t%.2f\n",goods.getId(),goods.getName(),goods.getPrice()));
            }
        }
        return sb.toString();
    }
}
