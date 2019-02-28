package com.github.liang.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author:lorrie
 * Create:2019/2/28
 */

/*
题目描述(剑指offer第三题)
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
class ListNode {
    int val;// 值
    ListNode next = null;//下一个结点

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintLinkedList {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(81);
        ListNode listNode3 = new ListNode(61);
        ListNode listNode4 = new ListNode(95);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        List<Integer> arrayList=printListFromTailToHead(listNode1);
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }

}
