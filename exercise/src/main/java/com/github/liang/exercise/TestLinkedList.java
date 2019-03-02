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
//public class TestLinkedList {
//    public static ListNode1 ReverseList(ListNode1 head) {
//
//        if(head==null){
//            return null;
//        }
//        if(head.next==null){
//            return head;
//        }
//        ListNode1 curr=head;//指向原链表的第一个结点
//        ListNode1 delNode=null;
//        ListNode1 news = null;
//        while (curr != null)
//        {
//            //从原链表头删，delNode是从原链表删掉的结点
//            delNode = curr;
//            curr = curr.next;
//            //头插到新结点
//            delNode.next = news;
//            news = delNode;
//        }
//        return news;
//    }
//
//    public static void main(String[] args) {
//       ListNode1 listNode1=new ListNode1(1);
//       ListNode1 listNode2=new ListNode1(2);
//       ListNode1 listNode3=new ListNode1(3);
//       ListNode1 listNode4=new ListNode1(4);
//       listNode1.next=listNode2;
//       listNode2.next=listNode3;
//       listNode3.next=listNode4;
//
//        System.out.println(ReverseList(listNode1).val);
//    }
//}


/*
题目描述
输入一个链表，输出该链表中倒数第k个结点。
 */
//public class TestLinkedList {
//    public static ListNode1 FindKthToTail(ListNode1 head, int k) {
//        if(head==null){
//            return null;
//        }
//
//        int len = 0;
//        ListNode1 curr=head;
//        while (curr!= null) {
//            len++;
//            curr=curr.next;
//        }
//        if(k>len){
//            return null;
//        }
//        curr=head;
//        for (int i = 0; i < len - k; i++) {
//
//            curr=curr.next;
//        }
//        return curr;
//    }
//
//    public static void main(String[] args) {
//        ListNode1 listNode1 = new ListNode1(1);
//        ListNode1 listNode2 = new ListNode1(2);
//        ListNode1 listNode3 = new ListNode1(3);
//        ListNode1 listNode4 = new ListNode1(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        System.out.println(FindKthToTail(listNode1,2).val);
//    }
//}

/*
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class TestLinkedList {

    public static ListNode1 Merge(ListNode1 list1,ListNode1 list2) {

        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode1 curr1=list1;
        ListNode1 curr2=list2;
        ListNode1 news=null;
        ListNode1 tail=null;
        ListNode1 node=null;
        while (curr1!=null&&curr2!=null) {
            if (curr1.val < curr2.val) {
                node = curr1;
                curr1=curr1.next;
                if (news == null) {
                    news = node;
                } else {
                    tail.next = node;
                }
                node.next = null;
                tail = node;
            }
            else {
                node=curr2;
                curr2=curr2.next;
                if (news == null) {
                    news = node;
                } else {
                    tail.next = node;
                }
                node.next = null;
                tail = node;
            }
        }

        if(curr1==null){
            tail.next=curr2;
        }
        if(curr2==null){
            tail.next=curr1;
        }
        return news;
    }

    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(1);
        ListNode1 listNode2 = new ListNode1(3);
        ListNode1 listNode3 = new ListNode1(5);
        ListNode1 listNode4 = new ListNode1(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode1 listNode5=new ListNode1(2);
        ListNode1 listNode6=new ListNode1(4);
        ListNode1 listNode7=new ListNode1(6);
        ListNode1 listNode8=new ListNode1(8);
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        ListNode1 listNode9=Merge(listNode1,listNode5);
        ListNode1 cur=listNode9;
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
