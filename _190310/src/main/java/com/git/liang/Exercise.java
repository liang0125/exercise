package com.git.liang;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * Author:lorrie
 * Create:2019/3/10
 */
public class Exercise {
    /*
    题目描述
二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
小易想知道最多可以放多少块蛋糕在网格盒子里
     */
    private static int count(int row, int col) {
        int count=0;
        //如果能整除4 那么蛋糕个数为网格个数的一半
        if(row%4==0 || col%4==0){
            count=row*col/2;
        }else{
            //不能被4整除 将蛋糕每隔一个空放一个 可以放多少 奇数的一半+1
            count=row*col/2+1;
        }
        return count;
    }
//    public static int num(int a,int b){
////        if(a==0&&b==0){
////            return 0;
////        }
////        int max=a;
////        if(b>a){
////            max=b;
////        }
////        if(a%b==0){
////            return a;
////        }
////        if (b%a==0){
////            return b;
////        }
////        else {
////            if(max==a){
////                int c=max%b;
////                while (b%c!=0){
////                    c=b%c;
////                }
////                return c*(b/c)*(a/c);
////            }
////            else {
////                int c=max%a;
////                while (a%c!=0){
////                    c=a%c;
////                }
////                return c*(b/c)*(a/c);
////            }
////        }
//        return max(a,b)*(a/max(a,b))*(b/max(a,b));
//    }
//    public static int max(int m,int n){
//        if(m<n){
//            int t=m;
//            m=n;
//            n=t;
//        }
//        if(m%n==0){
//            return n;
//        }
//        else {
//            return max(n,m%n);
//        }
//    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        System.out.println(count(m,n));
    }
}
