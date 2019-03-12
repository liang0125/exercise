package com.bittch.checkstand;

/**
 * Author:lorrie
 * Create:2019/1/11
 */
public interface GoodsCenter {
     void addGoods(Goods goods);
     void removeGoods(int id);
     void updateGoods(Goods goods);
     boolean isExistGoods(int id);
     Goods getGoods(int goods);
     String listGoods();
}
