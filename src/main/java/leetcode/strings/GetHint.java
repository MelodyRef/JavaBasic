package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode_299
 *
 * @author Melody
 * @date 2021/11/8 9:44
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        Map<Character, Integer> map = new HashMap<>(n);
        Map<Character, Integer> need = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }
        int cntA = 0, cntB = 0;
        for (int i = 0; i < n; ++i) {
            //位置相同，数字相同，公牛+1
            char ch = guess.charAt(i);
            if (secret.charAt(i) == ch) {
                cntA++;
                //map中对应字符减1,如果map中减1之后为0说明次数够了,need中如果包含这个字符也应该减1
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0 && need.containsKey(ch)) {
                    cntB--;
                    need.put(ch, need.get(ch) - 1);
                }

            } else {
                //位置不通，数字相同
                if (map.containsKey(ch)) {
                    //如果map中比need中大，说明还可以加
                    if (map.get(ch) > need.getOrDefault(ch, 0)) {
                        cntB++;
                        need.put(ch, need.getOrDefault(ch, 0) + 1);
                    }
                    //否则个数够了不再增加
                }
            }

        }
        return cntA + "A" + cntB + "B";
    }

    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        System.out.println(getHint.getHint("011", "110"));
    }
}
