/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int len1= word1.length(), len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        // 第一行
        for(int i = 0; i<= len2 ; i++)
            dp[0][i] = i;
        //第一列
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int min = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    min = Math.min(min, dp[i][j-1]);
                    dp[i][j] = min+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

