/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int[] mindp = new int[len];
        int[] maxdp = new int[len];

        maxdp[0] = nums[0]; // 记录最大值
        mindp[0] = nums[0];//记录最小值

        for (int i = 1; i < nums.length; i++) {
            // 
            maxdp[i] = Math.max(nums[i],  Math.max(nums[i] * maxdp[i-1], nums[i] * mindp[i-1]));
            mindp[i] = Math.min(nums[i], Math.min(nums[i] * maxdp[i-1], nums[i] * mindp[i-1]));
        }

        for (int i = 0; i < maxdp.length; i++) {
            max = Math.max(maxdp[i], max);
        }
        return max;
    }
}
// @lc code=end

