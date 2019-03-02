package com.github.liang.exercise;

import java.util.Stack;

/**
 * Author:lorrie
 * Create:2019/3/1
 */
/*
题目描述：
用两个栈来实现一个队列，完成队列的Push和Pop操作。
队列中的元素为int类型。
 */
public class TestQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        //直接入到第一个栈
        stack1.push(node);
    }

    public static int pop() {
        while (!stack1.isEmpty()){
            int data=stack1.pop();
            stack2.push(data);
        }
        int rsdata=stack2.pop();
        //每次进行出队操作要保证第二个栈是空的
        while(!stack2.isEmpty()){
            int data =stack2.pop();
            stack1.push(data);
        }
        return rsdata;
    }

    public static void main(String[] args) {
     push(1);
     push(2);
     push(3);
        System.out.println(pop());
        System.out.println(pop());
     push(4);
        System.out.println(pop());
     push(5);
        System.out.println(pop());
        System.out.println(pop());
    }
}
