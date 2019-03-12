package com.github.liang;

/**
 * Author:lorrie
 * Create:2019/3/9
 */

/*
小易买苹果，只能6个一袋或者8个一袋
最少多少袋？
 */
public class BuyApple {
    public static int buyApple(int n){
        if (n%2!=0||n<6||n==10){
            return -1;
        }
        else{
            if (n%8==0){
                return n/8;
            }
            else return 1+n/8;
        }

    }

    /*
    题目描述
    对字符串进行反转     时间复杂度必须为O（n）
    并且每个字符大小写互换
    例如：
    输入：Hello World
    输出：wORLD hELLO
     */
    public static String trans(String s, int n) {

        char[] c=s.toCharArray();
        reverse(c,0,n-1);
        reverseCase(c,n);
        int j=0;
        for(int i=0;i<n;i++){
            if (c[i]!=' '){
                j=i;
                break;
            }
        }
        for (int i=j;i<n;i++){
            if (c[i]==' '){
                reverse(c,j,i-1);
            j=i+1;
            }
        }
        reverse(c,j,n-1);
        String nerStr=new String(c);
        return nerStr;
    }
    public static char[] reverse(char[] c,int begin,int end){
        int i=begin;
        int j=end;
        while (i<j){
            char t=c[i];
            c[i]=c[j];
            c[j]=t;
            i++;
            j--;
        }
        return c;
    }
    public static char[] reverseCase(char [] c,int end){
        for(int m=0;m<end;m++){
            if(c[m]!=' ') {
                if (c[m] >= 'a' && c[m] <= 'z') {
                    c[m] -= 32;
                } else if (c[m] >= 'A' && c[m] <= 'Z') {
                    c[m] += 32;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
//        System.out.println(buyApple(30));
        System.out.println(trans("Hello World",11));
    }
}
