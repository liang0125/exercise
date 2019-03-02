package com.github.liang.exercise;

import java.util.LinkedList;

/**
 * Author:lorrie
 * Create:2019/3/2
 */
/*
题目描述
输入一个链表，反转链表后，输出新链表的表头。
 */
class ListNode1 {
    int val;
    ListNode1 next = null;

    ListNode1(int val) {
        this.val = val;
    }
}
public class TestLinkedList {
    public static ListNode1 ReverseList(ListNode1 head) {

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode1 curr=head;//指向原链表的第一个结点
        ListNode1 delNode=null;
        ListNode1 news = null;
        while (curr != null)
        {
            //从原链表头删，delNode是从原链表删掉的结点
            delNode = curr;
            curr = curr.next;
            //头插到新结点
            delNode.next = news;
            news = delNode;
        }
        return news;
    }

    public static void main(String[] args) {
       ListNode1 listNode1=new ListNode1(1);
       ListNode1 listNode2=new ListNode1(2);
       ListNode1 listNode3=new ListNode1(3);
       ListNode1 listNode4=new ListNode1(4);
       listNode1.next=listNode2;
       listNode2.next=listNode3;
       listNode3.next=listNode4;

        System.out.println(ReverseList(listNode1).val);
    }
}
