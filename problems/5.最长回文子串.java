/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2 )
            return s;
        
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        // dp[i][i] = true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // dp[i][j] 表示s[i,j]是否是回文
        for (int j= 1; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if(charArray[i] != charArray[j]) dp[i][j] = false;
                else{
                    if(j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }


                // 判断最大的
                if(dp[i][j] && (j- i+ 1 > maxLen)){
                    maxLen = j - i +1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }
}
// @lc code=end

