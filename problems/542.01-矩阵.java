import sun.nio.cs.ext.MacHebrew;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cows = mat[0].length;
        int[][] dp = new int[mat.length][mat[0].length];
        //
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                if(mat[i][j] == 0) dp[i][j] = 0;
                // else dp[i][j] =Integer.MAX_VALUE /2; // 为啥要除2防止越界,有越界的可能
                else dp[i][j] =Integer.MAX_VALUE -1;
            }
        }

        // 左上方向来
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cows; j++) {
                if (i -1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                if( j- 1 >= 0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1] +1);
            }
        }


        // 右下角过来

        for (int i = rows -1; i >= 0; i--) {
            for (int j = cows - 1; j >= 0; j--) {
                if(i + 1 < rows) dp[i][j] = Math.min(dp[i][j], dp[i+1][j] +1);
                if(j +1 < cows) dp[i][j] = Math.min(dp[i][j], dp[i][j+1] +1);
            }
        }

        return dp;
    }
}
// @lc code=end

