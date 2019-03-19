package com.github.liang;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * Author:lorrie
 * Create:2019/3/12
 */
public class Test {
//    public static int binInsert(int n, int m, int j, int i) {
//        m<<=j;
//        return n|m;
//
//    }



//    public static void main(String[] args) {
////        System.out.println(binInsert(1024, 19, 2, 6));
//        int x=0;
//        int y=0;
//        int z=0;
//
//        for(x=0;x<100;x++){
//            for (y=0;y<100;y++){
//                z=100-x-y;
//                if(z%3!=0){
//                    continue;
//                }
//                if(5*x+3*y+z/3==100){
//                    System.out.print(x+" "+y+" "+z);
//                    System.out.println();
//                }
//            }
//        }
//    }
    /*
    题目描述
    和奥巴马一起画正方形，行数是列数的50%
    输入：10 a
    输出：
    aaaaaaaaaa
    a        a
    a        a
    a        a
    aaaaaaaaaa

     */
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String c = sc.next();
    int row = N / 2;
    if (N % 2 != 0) {
        row = N / 2 + 1;
    }

    if (row == 2) {
        for (int i = 0; i < N; i++) {
            System.out.print(c);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(c);
        }
    } else {
        for (int i = 0; i < N; i++) {
            System.out.print(c);
        }
        System.out.println();
        for (int i = 0; i < row - 2; i++) {
            System.out.print(c);
            for (int j = 0; j < N - 2; j++) {
                System.out.print(" ");
            }
            System.out.print(c);
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            System.out.print(c);
        }
    }
}
}
