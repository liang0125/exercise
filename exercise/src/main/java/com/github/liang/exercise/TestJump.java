package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/2
 */
/*
题目描述：
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法
（先后次序不同算不同的结果）。

对于本题，对于本题,前提只有1阶或者2阶的跳法。
a.如果两种跳法，1阶或者2阶，那么假定第一次跳的是一阶，那么剩下的是n-1个台阶，跳法是f(n-1);
b.假定第一次跳的是2阶，那么剩下的是n-2个台阶，跳法是f(n-2)
c.由a、b假设可以得出总跳法为: f(n) = f(n-1) + f(n-2)
d.然后通过实际的情况可以得出：只有一阶的时候 f(1) = 1 ,只有两阶的时候可以有 f(2) = 2
e.可以发现最终得出的是一个斐波那契数列：
 */
public class TestJump {
//    public static int JumpFloor(int target) {
//        if(target==1){
//            return 1;
//        }
//        else if (target==2){
//            return 2;
//        }
//        int first=1;
//        int second=2;
//        int third=0;
//        for(int i=3;i<=target;i++){
//            third=first+second;
//            first=second;
//            second=third;
//        }
//        return third;
//    }


    /*
    题目描述
    一只青蛙一次可以跳上1级台阶
    也可以跳上2级……它也可以跳上n级。
    求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */

    /*
    跳一级，则剩下的就是f(n-1)
    跳两级,剩下的就是f(n-2)
    ...n-1         f(1)
    所以f(n)=f(n-1)+f(n-2)+....f(1)
    f(n-1)=f(n-2)+...f(1)
    两式相减得：
    f(n)=2*f(n-1)
     */
    public static int JumpFloorII(int target) {

        if(target==1){
            return 1;
        }
        else if (target==2){
            return 2;
        }

        return 2*JumpFloorII(target-1);
    }

    public static void main(String[] args) {
        //System.out.println(JumpFloor(1));
        System.out.println(JumpFloorII(4));
    }
}
