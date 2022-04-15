package leetcode.array.monotonousStack;

import java.util.Stack;

/**
 * LeetCode_
 *
 * @author Melody
 * @date 2021/11/29 15:27
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        int ans[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; ++i) {
            int top = stack.peek();
            if (temperatures[top] >= temperatures[i]) {
                stack.push(i);
            }
            //找到比自己大的，出栈

            else {
                while (!stack.isEmpty() && temperatures[top] < temperatures[i]) {
                    top = stack.peek();
                    ans[top] = i - top;
                    stack.pop();
                }
            }
            if (temperatures[top] < temperatures[i]) {
                while (!stack.isEmpty() && temperatures[top] < temperatures[i]) {
                    ans[top] = i - top;
                    stack.pop();
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                    }

                }
                stack.push(i);
            }

        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        d.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
