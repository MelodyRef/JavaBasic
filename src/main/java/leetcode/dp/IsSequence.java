package leetcode.dp;

/**
 * 判断字符串s是否是t的子序列
 * 子序列：原始字符串删除一些字符（也可以不删）按照原顺序排列的字符串
 * @author Melody
 * @date 2021/10/19 10:58
 */
public class IsSequence {
    //贪心求解，双指针，s和t每匹配一个字符就都往后，不匹配则t往后s不变
    public boolean isSequence(String s, String t) {
        if (s.length() > t.length())
            return false;
        int i, j;
        i = j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == s.length())
            return true;
        else return false;
    }
}
