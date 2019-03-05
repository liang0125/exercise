package com.github.liang.exercise;

import java.util.Stack;

/**
 * Author:lorrie
 * Create:2019/3/5
 */
public class TestStack {
    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> minStack=new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
            if (minStack.isEmpty()||node<(minStack.peek())){
                minStack.push(node);
            }
            else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            stack1.pop();
            minStack.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return minStack.peek();
        }

}
