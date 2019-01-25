package com.bittch.checkstand;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public interface GoodsCenter {
     void addGoods(Goods goods);
     void removeGoods(String id);
     void updateGoods(Goods goods);
     boolean isExistGoods(String id);
     Goods getGoods(String goods);
     String listGoods();
     void store();
     void load();
}
