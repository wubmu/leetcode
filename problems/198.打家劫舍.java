/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    // public int rob(int[] nums) {
    //     int len = nums.length;
    //     int[] dp = new int[len + 1];
    //     dp[0] = 0; //表示
    //     dp[1] = nums[0];
    //     for (int i = 2; i < dp.length; i++) {
    //         // 偷第 i家 dp[i] = dp[i-2]  + nums[i -1]
    //         // 不偷第i家 dp[i]  = dp[i-1]
    //         dp[i] = Math.max(dp[i -1], dp[i-2] + nums[i-1]);
    //     }

    //     return dp[len];
    // }


    /***
     * 空间优化
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        int pre = 0;       // 第一家不被偷的价值
        int dp = nums[0]; // 第一家被偷的价值
        for (int i = 2; i <= nums.length; i++) {
            // 偷第 i家 dp = pre  + nums[i -1]
            // 不偷第i家 dp = dp
            int cur = Math.max(dp, pre + nums[i-1]);
            
            pre = dp;
            dp = cur;

        }

        return dp;
    }
}
// @lc code=end

