package com.github.liang.exercise;

import java.util.Queue;

/**
 * Author:lorrie
 * Create:2019/3/3
 */

/*
题目描述
用快排的思想找出数组中第K个大的数
 */
public class TestKMax {
    public static int findKth(int[] a, int n, int k) {
        // write code here
        if(a==null){
            return -1;
        }
        _QuickSort(a,0,a.length-1);

        return a[k-1];
    }

public static int Partition_02(int array[], int left, int right)
{
    int begin = left;
    int end = right;
    int priot = array[right];
    while (begin < end)
    {
        while (begin < end&&array[begin] >= priot)
        {
            begin++;
        }
        array[end] = array[begin];
        while (begin < end&&array[end] <= priot)
        {
            end--;
        }
        array[begin] = array[end];
    }
    array[begin] = priot;
    return begin;
}
   public static void _QuickSort(int array[],int left,int right)
    {
        if (left == right)
        {
            return;
        }
        if (left > right)
        {
            return;
        }
        int div = Partition_02(array, left, right);
        _QuickSort(array, left, div - 1);
        _QuickSort(array, div + 1, right);
    }

    public static void main(String[] args) {
        int []arr={1,5,2,4,3};
        _QuickSort(arr,0,4);
for (int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}
        //System.out.println(n);
    }
}
