/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp  = new int[n +1];
        for (int i = 1; i <= n; i++) {
            int minvalue = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minvalue = Math.min(minvalue, dp[i - j*j] +1);
            }
            dp[i] = minvalue;
        }

    return dp[n];
    }
}
// @lc code=end

