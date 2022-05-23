/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = dungeon[0][0];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if(i==0) dp[0][j] = dp[0][j-1];
            }
        }
    }
}
// @lc code=end

