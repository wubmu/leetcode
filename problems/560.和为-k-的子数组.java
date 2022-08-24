import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length +1];
        int count = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i-1] + sums[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= nums.length; i++) {
            int t = sums[i];
            int d = t - k;
            count += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0)+1);
        }
        return count;
    }
}
// @lc code=end

