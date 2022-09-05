/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    // public boolean isSubsequence(String s, String t) {
    //     if(s.length()<1)
    //         return true;
    //     int index_s = 0;
    //     for(int index_t =0;index_t<t.length(); index_t++){
    //         if(t.charAt(index_t) == s.charAt(index_s) ){
    //             index_s++;
    //             if(index_s == s.length())
    //             return true;
    //         }
    //     }

    //     return false;
    // }


    /**
    官方双指针
     */
    // public boolean isSubsequence(String s, String t) {
    //     int n =0, m=0;
    //     while(n<s.length() && m < t.length()){
    //         if(s.charAt(n) == t.charAt(m))
    //             n++;
    //         m++;
    //     }

    //     return n==s.length();
    // }



    /**
    动态规划
    dp[i][j],长度为i，末尾项为s[i-1]的子字符串，
    与长度为j，末尾项为t[j-1]的子字符串，二者的相同子序列长度。

    s[i-1] == t[i-1], dp[i][j] = dp[i-1][j-1] +1
    s[i-1] != t[i-1], dp[i][j] = dp[i][j-1]
    时间复杂度：O(mn)
    空间复杂度: O（nm）
     */
    // public boolean isSubsequence(String s, String t) {
    //     int n = s.length(), m = t.length();

    //     int[][] dp = new int[n+1][m+1];
    //     // dp[i][0], dp[0][j] == 0
    //     for(int i=1; i<=n;i++){
    //         for(int j = 1; j<=m ; j++){
    //             if(s.charAt(i-1) == t.charAt(j-1))
    //                 dp[i][j] = dp[i-1][j-1] + 1;
    //             else
    //                 dp[i][j] = dp[i][j-1];
    //         }
    //     }

    //     return dp[n][m] == n;
    // }


    /***
    大量s匹配问题

    dp[n][26] 记录下一个字母出现的位置
     */
    public boolean isSubsequence(String s, String t) {
        // 预处理
        t = " " +t; //开头加一个空格作为匹配的入口
        int n = t.length();
        int[][] dp = new int[n][26]; // 下一个位置出现ch的位置
        for (int ch = 0; ch < 26; ch++) {
            int p = -1;

            for (int i = n-1; i  >=0; i--) {
                dp[i][ch] = p;
                if(t.charAt(i) == ch+'a') p = i;
            }
        }

        // 开始匹配
        int i = 0;
        for (char ch : s.toCharArray()) {
            i = dp[i][ch-'a'];
            if(i == -1) return false;
        }

        return true;

    }


    

    
}
// @lc code=end

