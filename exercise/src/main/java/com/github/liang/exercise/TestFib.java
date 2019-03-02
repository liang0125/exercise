package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/2
 */
/*
题目描述：
大家都知道斐波那契数列，现在要求输入一个整数n
请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
public class TestFib {
//    public static int fibonacci(int n) {
//    if(n==0){
//        return 0;
//    }
//    if (n==1){
//        return 1;
//    }
//    else return fibonacci(n-1)+fibonacci(n-2);
//    }

    //非递归
//    public static int fibonacci(int n) {
//       int [] arr=new int[n+1];
//       arr[0]=0;
//       arr[1]=1;
//       for(int i=2;i<=n;i++){
//           arr[i]=arr[i-1]+arr[i-2];
//       }
//       return arr[n];
//    }


    public static int fibonacci(int n) {
        int first=0;
        int second=1;
        int third=0;
        for(int i=2;i<=n;i++){
            third=first+second;
            first=second;
            second=third;
        }
        return third;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(38));
    }
}
