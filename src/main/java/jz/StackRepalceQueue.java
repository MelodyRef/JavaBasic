package jz;

import java.util.Stack;

public class StackRepalceQueue {
    //中间栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //反向栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int ans = stack2.peek();
        stack2.pop();
        return ans;
    }
}
