package leetcode;

import java.util.HashMap;

/**
 * @Classname MinWindow
 * @Description TODO
 * @Version 1.0.0
 * @Date 2021/10/14 23:07
 * @Created by Melody
 */
public class MinWindow {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();

    public String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        //初始化need窗口
        for (char c : s2) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left, right, valid;
        left = right = valid = 0;
        //start记录最小覆盖字串的起始索引
        int start = 0, length = Integer.MAX_VALUE;

        while (right < s1.length) {
            //c是放入窗口的字符
            char c = s1[right];

            //右移窗口
            right++;

            //进行窗口的一系列数据更新
            //如果need窗口中包含c即是需要字符
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //need和window中对应字符数目相同，即满足条件
                if (need.get(c).intValue() == window.get(c).intValue()) {
                    valid++;
                }
            }

            //判断左窗口是否需要收缩
            //window窗口满足need窗口后开始收缩
            while (need.size() == valid) {
                //当前窗口长度满足比之前小
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                //c1是将要移出窗口的字符
                char c1 = s1[left];
                //左移窗口
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).intValue() == need.get(c1).intValue()) {
                        valid--;
                    }
                    window.replace(c1, window.get(c1) - 1);
                }

            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start+length);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        String s1 = "";
    }
}
