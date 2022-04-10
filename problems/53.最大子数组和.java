/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i] + pre, nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
// @lc code=end

