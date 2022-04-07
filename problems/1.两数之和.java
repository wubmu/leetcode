import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0 ; i< nums.length; i++){
            if(hash.containsKey(target- nums[i])){
                return new int[]{hash.get(target-nums[i]), i};
            }
            hash.put(nums[i], i);
        }

        return new int[2];
    }
}
// @lc code=end

