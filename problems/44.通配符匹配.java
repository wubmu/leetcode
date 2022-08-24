/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        
        for (int i = 1; i <= len2; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }


    

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] | dp[i-1][j];
                }else if(p.charAt(j-1)== s.charAt(i-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

    return dp[len1][len2];
    }
}
// @lc code=end

