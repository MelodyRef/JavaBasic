package jz;

import java.util.Stack;

public class StackRepalceQueue {
    //中间栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //结果栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //入栈和出栈大小不同说明有pop，将出栈内容转移到入栈
        if (stack1.size() != stack2.size()) {
            stack1.clear();
            while (!stack2.empty()){
                int tmp = stack2.peek();
                stack1.push(tmp);
                stack2.pop();
            }
        }
     //新节点入栈,清空出栈重新生成出栈
        stack1.push(node);
        stack2.clear();
        while (!stack1.empty()){
            int tmp = stack1.peek();
            stack2.push(tmp);
            stack1.pop();
        }
    }

    public int pop() {
        int ans = stack2.peek();
        stack2.pop();
        return ans;
    }
}
