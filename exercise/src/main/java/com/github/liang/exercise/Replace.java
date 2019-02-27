package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/2/27
 */
/*
题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Replace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("We");
        sb.append(" ");
        sb.append("Are");
        sb.append(" ");
        sb.append("Happy");
        String s = replaceChar(sb);
        System.out.println(s);
    }

    public static String replaceChar(StringBuffer str) {
        char[] str1=str.toString().toCharArray();
        StringBuffer sb=new StringBuffer();
       for(int i=0;i<str1.length;i++){
           if(str1[i]==' '){
               sb.append("%20");
               continue;
           }
           sb.append(str1[i]);
       }
       return sb.toString();
    }

}
