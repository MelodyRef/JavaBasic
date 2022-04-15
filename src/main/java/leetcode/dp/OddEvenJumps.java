package leetcode.dp;

import java.util.Arrays;

/**
 * LeetCode_975-hard
 * 奇偶跳问题
 * 数组从当前索引奇数次跳时只能跳到后面比自己大的最小索引处，偶数次跳时只能跳后面比自己小的最小索引出
 * 求解数组中能到达数组末尾出的索引数量
 * <p>
 * <p>
 * 首先构建两个数组odd和even,数组中的值代表从当前索引出发奇数（偶数）次跳的下一个节点索引
 *
 * @author Melody
 * @date 2021/12/21 15:08
 */
public class OddEvenJumps {
    public int oddEvenJumps(int[] arr) {
        int[][] dp = new int[arr.length][2];
        int n = arr.length;
        dp[n - 1][0] = n - 1;
        dp[n - 1][1] = n - 1;
        int[] odd = new int[n];
        int[] even = new int[n];
        Arrays.fill(odd, -1);
        Arrays.fill(even, -1);
        odd[n - 1] = n - 1;
        even[n - 1] = n - 1;



        for (int i = 0; i < n-1; ++i) {
            int maxIndex = -1, minIndex = -1;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; ++j) {
                //满足奇数次跳
                if (arr[j] >= arr[i] && arr[j] < max) {
                    max = arr[j];
                    maxIndex = j;
                }
                //满足偶数次跳
                if (arr[j] <= arr[i] && arr[j] > min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            odd[i] = maxIndex;
            even[i] = minIndex;
        }
        //从后往前构建dp数组
        for (int i = n - 2; i >= 0; --i) {
            if (odd[i] != -1) {
                dp[i][0] = dp[odd[i]][1];
            }
            if (even[i] != -1) {
                dp[i][1] = dp[even[i]][0];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i][0] == n - 1) {
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        OddEvenJumps oddEvenJumps = new OddEvenJumps();
        System.out.println(oddEvenJumps.oddEvenJumps(new int[]{81, 54, 96, 60, 58}));
    }

}
