package leetcode.array.monotonousStack;

import java.util.Stack;

/**
 * LeetCode_1475-easy
 * 商品折扣后的最终价格
 * 商品价格price[i]，折扣为j>i且price[j]<=price[i]的最小下标处值
 * 返回折扣后的商品价格
 *
 * @author Melody
 * @date 2021/12/23 9:58
 */
public class FinalPrices {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - prices[stack.peek()];
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        FinalPrices finalPrices = new FinalPrices();
        System.out.println(finalPrices.finalPrices(new int[]{8, 4, 6, 2, 3}));
    }
}
