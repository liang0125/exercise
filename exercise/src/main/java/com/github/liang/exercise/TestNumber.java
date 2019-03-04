package com.github.liang.exercise;

import java.util.Scanner;

/**
 * Author:lorrie
 * Create:2019/3/3
 */
/*
题目描述
输入字符串1和字符串2，将字符串2插入到字符串1中
有几种方法插入完后是回文序列
 */
public class TestNumber {
    public static int find(String str1,String str2) {

        int len=0;
        String s1="";
        String s2="";
        String s3="";
        if(isSpecial(str2+str1)){
            len++;
        }
        if(isSpecial(str1+str2)){
            len++;
        }
        for(int i=1;i<str1.length();i++){
            s1=str1.substring(0,i);
            s2=str1.substring(i);
            if(isSpecial(s1+str2+s2)){
                len++;
            }
        }
        return len;
    }

    public static boolean isSpecial(String str1){
        char[] arr=str1.toCharArray();
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            if(arr[left]==arr[right]){
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str1=in.nextLine();
        String str2=in.nextLine();
        System.out.println(find(str1,str2));
    }
}
