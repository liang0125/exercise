package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/4
 */

/*
题目描述
给定一个double类型的浮点数base和int类型的整数exponent。
求base的exponent次方。

注意要考虑exponent的正负
 */
public class TestPower {
    public static double Power(double base, int exponent) {

        double rs=1;
        if(exponent>=0) {
            for (int i = 0; i < exponent; i++) {
                rs = rs * base;
            }
        }else {
            for (int i = 0; i <(-exponent); i++) {
                rs = rs * base;
            }
            rs=1/rs;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(Power(0.5D,3));
    }
}
