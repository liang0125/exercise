package com.github.liang.exercise;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * Author:lorrie
 * Create:2019/3/5
 */
/*
题目描述：
给定一个字符串（数字或大小写字母）, 找出最长的对称的子串（如有多个，输出任意一个）。
例如：
输入：“abbaad”
输出：“abba”
 */
public class TestStr {

    public static String subStr(String str){

        if(str.length()==0){
            return "";
        }
        String st="";
        for(int i=0;i<str.length();i++) {
            for (int j = str.length(); j > i; j--) {
                String s = str.substring(i, j);
                if (isSpecial(s)) {
                    if(s.length()>st.length()) {
                         st=s;
                    }
                }
            }
        }
        return st;
    }
    public static boolean isSpecial(String str){
        char[] c=str.toCharArray();
        int left=0;
        int right=c.length-1;
        while (left<right){
            if(c[left]==c[right]){
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.println(subStr(str));
    }

}
