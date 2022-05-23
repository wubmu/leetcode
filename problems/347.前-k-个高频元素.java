import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    // public int[] topKFrequent(final int[] nums, final int k) {
    //     // 先统计频率
    //     final Map<Integer, Integer> map = new HashMap<>();
    //     for (final int i : nums) {
    //         if (map.containsKey(i))
    //             map.put(i, map.get(i) + 1);
    //         else
    //             map.put(i, 1);
    //     }
    //     final List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
    //     Collections.sort(entries, (o1, o2) -> (o2.getValue() - o1.getValue()));
    //     final int[] ans = new int[k];
    //     for (int i = 0; i < k; i++) {
    //         ans[i] = entries.get(i).getKey();
    //     }
    //     return ans;
    // }


    public int[] topKFrequent(final int[] nums, final int k) {
        // 先统计频率
        final Map<Integer, Integer> map = new HashMap<>();
        for (final int i : nums) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int Comparator(int[] m , int[] n){
                return m[1] - n[1];
            }
        });
        for(map.Ent)

    }
}
// @lc code=end

