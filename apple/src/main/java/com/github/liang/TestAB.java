package com.github.liang;

import java.util.Scanner;

/**
 * Author:lorrie
 * Create:2019/3/9
 */
public class TestAB {
    public static int[] value(int a,int b,int c,int d){
        if (a==0&&b==0&&c==0&&b==0){
            int [] arrs=new int[3];
            arrs[0]=0;
            arrs[1]=0;
            arrs[2]=0;
        }
        else if(a>=c||b>=d){
            return null;
        }
            int m = (a + c) / 2;
            int n = (b + d) / 2;
            int p = d - n;
            if (m * 2 != (a + c) || n * 2 != (b + d)) {
                return null;
            } else {
                int[] arr = new int[3];
                arr[0] = m;
                arr[1] = n;
                arr[2] = p;
                if((arr[0]-arr[1]==a)&&(arr[1]-arr[2]==b)&&(arr[0]+arr[1]==c)&&(arr[1]+arr[2]==d)) {
                    return arr;
                }
                else {
                    return null;
                }
            }

    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        int d=in.nextInt();
        int array[]=value(a,b,c,d);
        if(array!=null){
            for(int i=0;i<3;i++){
                System.out.print(array[i]);
                if(i!=2){
                    System.out.print(" ");
                }
            }
        }
        else {
            System.out.println("No");
        }
    }
}
