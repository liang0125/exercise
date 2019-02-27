package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/2/27
 */

/*
 *剑指offer（java）第一题
 * 题目描述：
 *在一个二维数组中（每个一维数组的长度相同），
 *每一行都按照从左到右递增的顺序排序，
 *每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 */
public class Find {
    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean flag = solution(5, arr);
        System.out.println(flag);
    }

    public static boolean solution(int target, int[][] arr) {
        if (arr == null) {
            return false;
        }
        int i = 0;
        int j = arr[0].length;
        int start;
        while (i < arr.length && j > 0) {
            start = arr[i][j - 1];
            if (target < start) {
                j--;
            } else if (target > start) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
