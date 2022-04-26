package leetcode;

import sun.nio.cs.ext.MacHebrew;


/**
 * @Classname Solution
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/23 11:37
 * @Created by Melody
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int l = area;
        int w = 1;
        int min = l - w;
        int quar = (int) Math.pow(area, 0.5);
        for (int i = 1; i <= quar; ++i) {
            for (int j = area; j > i; --j) {
                if (i * j == area) {
                    l = j;
                    w = i;
                }
            }
        }
        return new int[]{l, w};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.constructRectangle(26);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
