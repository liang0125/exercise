package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/4
 */

/*
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？


依然是斐波那契数列的思想

第一次摆放2*1个，那么就剩（target-2），因为上面摆了2*1的造型，那么它下面的造型就定了，只能摆放2*1
第一次如果摆放1*2个，那么就剩（target-1）
 */
public class TestCover {
    public static int RectCover(int target) {

        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if(target==2){
            return 2;
        }
        return RectCover(target-1)+RectCover(target-2);
    }

    public static void main(String[] args) {
        System.out.println(RectCover(5));

    }
}
