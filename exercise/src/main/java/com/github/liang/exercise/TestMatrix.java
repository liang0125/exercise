package com.github.liang.exercise;

import java.util.ArrayList;

/**
 * Author:lorrie
 * Create:2019/3/4
 */

/*
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如:
如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class TestMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;
        if(matrix==null){
            return null;
        }
        if (rLen==0){
            return null;
        }
        while ((rLen > start * 2) && (cLen > start * 2)) {
            int endX = cLen - start - 1;
            int endY = rLen - start - 1;

            //从左到右打印第一行
            for (int i = start; i <= endX; i++) {
                list.add(matrix[start][i]);
            }
            if ((start < endY)) {
                //从上到下打印最后一列
                for (int i = start + 1; i <= endY; i++) {
                    list.add(matrix[i][endX]);
                }
            }
            if ((start < endX) && (start < endY)) {
                //从右到左打印最后一行
                for (int i = endX-1; i >= start; i--) {
                    list.add(matrix[endY][i]);
                }
            }
            if ((start < endX) && (start < (endY-1))) {
                for (int i = endY - 1; i >= start+1; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;

        }
        return list;
    }
        public static void main(String[] args) {
        int[][] arr = {{1},{2},{ 3}, {4},{5}};
        System.out.println(printMatrix(arr));
    }
}


