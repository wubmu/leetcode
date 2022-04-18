/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    // public int minPathSum(int[][] grid) {
    //     int[][] dp =  new int[grid.length][grid[0].length];

    //     // 初始化
    //     dp[0][0] = grid[0][0];
    //     // for (int i = 1; i < dp.length; i++) {
    //     //     dp[i][0] = dp[i-1][0] + grid[i][0];
    //     // }
    //     // for (int j = 1; j < grid[0].length; j++) {
    //     //     dp[0][j] = dp[0][j-1] + grid[0][j];
    //     // }

    //     for (int i = 0; i < dp.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             if(i==0 && j==0) dp[0][0] = grid[0][0];
    //             else if(i == 0) dp[0][j] = dp[0][j-1] + grid[0][j];
    //             else if (j == 0) dp[i][0] = dp[i-1][0] + grid[i][0];
    //             else dp[i][j] = Math.min(dp[i][j-1] , dp[i-1][j]) + grid[i][j];
    //         }    
    //     }
    //     return dp[grid.length - 1][grid[0].length -1];
    // }


    public int minPathSum(int[][] grid) {
        int[] dp  = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i ==0 && j ==0) dp[j] = grid[0][0];
                else if(i == 0) dp[j] = dp[j-1] + grid[i][j];
                else if(j == 0) dp[j] = dp[j] + grid[i][j];
                else dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }


}
// @lc code=end

