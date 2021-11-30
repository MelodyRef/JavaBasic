package leetcode.dp;

/**
 * @author Melody
 * @date 2021/11/8 10:08
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreEnd * turn, scoreStart * turn) * turn;
    }

    public boolean predict(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;
        //dp[i][j]数组的i到j时候，第一个人分数，第二个人分数
        int[][][] dp = new int[n][n][2];
        //base case，只有一个元素时，先手人拿，后手0分
        for (int i = 0; i < n; ++i) {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = 0;
        }
        //状态:数组起始i,数组末尾j,当前轮到的人
        //状态转移方程：dp[i][j][0]= max(取第一个数，取第二个数)=》dp[i][j][0]=max(nums[i]+dp[i+1][j][1],nums[j]+dp[i][j-1][1])
        //dp[i][j][1]=max()
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                int left = nums[i] + dp[i + 1][j][1], right = nums[j] + dp[i][j - 1][1];
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][n - 1][0] > dp[0][n - 1][1] ? true : false;

    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        System.out.println(predictTheWinner.predict(new int[]{1, 5, 2}));
    }
}
