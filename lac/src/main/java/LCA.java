/**
 * Author:lorrie
 * Create:2019/3/11
 */

import java.math.BigInteger;
import java.util.*;

/*
题目描述
求公共祖先，满二叉树，根节点是1，给出两个数，求这两个数的最近公共祖先
 */
public class LCA {
//    public static int getLCA(int a, int b) {
//        if(a==1||b==1){
//            return 1;
//        }
//        if (a==b){
//            return a;
//        }
//        else {
//            int x=getLCA(a/2,b);
//            int y=getLCA(a,b/2);
//            if (x>y){
//                return x;
//            }
//            else {return y;}
//        }
//    }

    //    public static int getLCA(int a, int b) {
//       while (a!=b){
//           if (a>b){
//               a=a/2;
//           }
//           else {
//               b=b/2;
//           }
//       }
//       return a;
//    }

    /*
    题目描述
    1-100阶乘之和，由于越界，所以使用java的大数类即BigInteger类，其中multity()和add()方法很管用
     */
    public static BigInteger fac(int n) {
        BigInteger rs=new BigInteger(String.valueOf(1));
        BigInteger sum=new BigInteger(String.valueOf(0));
        if (n == 0 || n == 1) {
            return new BigInteger(String.valueOf(1));
        } else {
            for(int i=1;i<=n;i++) {
                rs=rs.multiply(BigInteger.valueOf(i));
                sum=sum.add(rs);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fac(100));
    }

    /*
    题目描述
    字符串反转
     */

//    public static String reverse(String str){
//        if (str==null){
//            return null;
//        }
//        if (str.equals("")){
//            return "";
//        }
//      else {
//            char[] c = str.toCharArray();
//            int begin = 0;
//            int end = c.length - 1;
//            while (begin < end) {
//                char t = c[begin];
//                c[begin] = c[end];
//                c[end] = t;
//                begin++;
//                end--;
//            }
//            String newStr = new String(c);
//            return newStr;
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String s=in.nextLine();
//        System.out.println(reverse(s));
//    }
}