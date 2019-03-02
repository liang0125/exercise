package com.github.liang.exercise;

/**
 * Author:lorrie
 * Create:2019/3/2
 */
/*
题目描述：
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。



 这道题貌似过于简单了。。。出题人本意应该不是这样吧，跟旋转没关系呀
 */
public class TestRotate {
    public static int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int min=array[0];
        for(int i=0;i<array.length;i++){
           if(array[i]<min){
               min=array[i];
           }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr={5, 4, 3, 1, 2};
        int m=minNumberInRotateArray(arr);
        System.out.println(m);
    }
}
