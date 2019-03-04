package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/4
 */

/*
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class TestCount {
    public static int NumberOf1(int n) {
        int count=0;
        for(int i=31;i>=0;i--){
            if(((n>>i)&1)==1){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int a=-5;
        System.out.println(NumberOf1(a));
    }
}
