package leetcode;

import java.util.HashMap;

/**
 * 滑动窗口算法框架
 *
 * @author Melody
 * @date 2021/10/14 15:20
 */

public class SlidingWindow {
    void slidingWindow(char[] s, char[] t) {
        HashMap<Character, Integer> need, window;
        need = new HashMap<>();
        window = new HashMap<>();
        for (char c : s) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length) {
            //c 是将移入窗口的字符
            char c = s[right];
            //右移窗口
            right++;
            //...进行窗口内数据的一系列更新

            /**
             * debug输出的位置
             */
            System.out.println(left + "  " + right);

            //判断左侧窗口是否需要收缩
//            while (window needs shrink){
                //d是将移出窗口的字符
                char d = s[left];
                //左移窗口
                left++;

                //进行窗口内数据的一系列更新
                //...

//            }
        }
    }

}
