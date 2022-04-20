/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        /**
         * 可以单独解码
         * 
         */
        if(s.charAt(0) == '0')
            return 0;
        int n = s.length();
        s = " "+s;// 哨兵
        int[] dp = new int[s.length() +1 ];
        dp[0] =1;
        // dp[1] =1;
        for (int i = 1; i <=n; i++) {
            int last = s.charAt(i-1) - '0';
            int cur = s.charAt(i) - '0';
            int num = last * 10 + cur;
            if(cur >=1 && cur<=9)
                dp[i] = dp[i-1];
            if(num>=10 && num <=26)
                dp[i] += dp[i-2]; 
        }
        return dp[n];
    }
}
// @lc code=end

