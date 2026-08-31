package com.leetcode.minstack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(final int val) {
        this.stack.push(val);
        this.minStack.push(this.minStack.isEmpty() || this.minStack.peek() > val ? val : this.minStack.peek());
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */