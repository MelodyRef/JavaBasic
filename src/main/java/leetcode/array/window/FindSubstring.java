package leetcode.array.window;

import java.util.*;

/**
 * @author Melody
 * @date 2022/5/20 14:24
 */
public class FindSubstring {


    public static void main(String[] args) {
        List<Integer> list = findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return null;
        }
        List<Integer> ans = new ArrayList<>();
        int step = words[0].length();
        int count = words.length;
        Map<String, Integer> window = new HashMap<>();
        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            need.put(words[i], need.getOrDefault(words[i], 0) + 1);
        }


        int left = 0, right = 0, valid = 0;
        while (right + step <= s.length()) {
            String str = s.substring(right, right + step);
            right = right + step;

            if (need.containsKey(str)) {
                window.put(str, window.getOrDefault(str, 0) + 1);
                if (window.get(str).equals(need.get(str))) {
                    valid++;
                }
            } else {
                left++;
                right = left;
                valid = 0;
                window.clear();
            }

            //当目前窗口中长度满足字符串数组总长时
            if (right - left >= count * step) {
                //满足条件直接更新结果集
                if (valid == need.size()) {
                    ans.add(left);

                }
                left++;
                right = left;
                valid = 0;
                window.clear();
            }
        }

        return ans;
    }


}
