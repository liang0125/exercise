package com.github.liang;

import java.util.Scanner;

/**
 * Author:lorrie
 * Create:2019/3/9
 */
public class TestS {
//    public static int[] square(int[] arr){
//        int[] newArr=new int[arr.length];
//        for (int i=0;i<arr.length;i++){
//            newArr[i]=arr[i]*arr[i];
//        }
//        return newArr;
//    }
//
//    public static void main(String[] args) {
//        int[] a={1,2,3,4};
//        int[] ar=square(a);
//        for (int i=0;i<a.length;i++){
//            System.out.println(ar[i]);
//        }
//
//    }

    public static int series(int n){
        if( n>0&&n<Integer.MAX_VALUE) {

            if (n == 0) {
                return 0;
            } else {
                int[] arr = new int[n];
                arr[0] = 2;
                int sum = arr[0];
                for (int i = 1; i < n; i++) {
                    arr[i] = arr[i - 1] + 3;
                    sum += arr[i];
                }
                return sum;
            }
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        System.out.println(series(a));
    }

}
