package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Melody
 * @date 2021/12/13 14:15
 */
public class TopVotedCandidate {
    int[] persons;
    int[] times;
    int[] search;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        search[0] = persons[0];
    }

    //查询时候时间
    //思路，只统计投票时间小于等于t的
    public int q(int t) {
        int max = -1;
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length && times[i] <= t; ++i) {
            int person = persons[i];
            map.put(person, map.getOrDefault(person, 0) + 1);
            int size = map.get(person);
            //要求票数相同时选取最后获取票的，所以相同时也更新
            if (size >= max) {
                ans = person;
                max = size;
            }
        }
        return ans;
    }

}
