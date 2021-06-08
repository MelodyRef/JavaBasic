package leetcode.strings;

import java.util.Arrays;
import java.util.stream.IntStream;

//求解两个字符串的编辑距离（从一个字符串转换为另一个字符串最少需要的步数）
public class EditDistance {

    public int editDistance(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int dp[][] = new int[l1][l2];
        int i = l1 - 1, j = l2 - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i)==s2.charAt(j)) {
                return editDistance(s1.substring(0,i-1),s2.substring(0,j-1));
            }
        }
        return dp[l1 - 1][l2 - 1];
    }

    public static void main(String[] args) {
        int nums[][] = {{2,4,6},{1,2,3}};
        for(int n[]:nums){
            IntStream stream = Arrays.stream(n);
            stream.forEach(System.out::println);
        }
    }
}
