import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    // s[i]= s[j] : dp[i][j] = dp[i+1][j-1] +2
    // s[i]=s[j] : dp[i][j] = (dp[i+1][j] ,dp[i][j+1])
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] =1;
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1]+2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return dp[0][n-1];
    }
}
// @lc code=end

