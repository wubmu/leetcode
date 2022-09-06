/*
 * @lc app=leetcode.cn id=1312 lang=java
 *
 * [1312] 让字符串成为回文串的最少插入次数
 */

// @lc code=start
class Solution {

    //1、s.charAt(i)==s.charAt(j) 此时不需要计算，取其内部字符串的值就行
// 2、s.charAt(i)！=s.charAt(j) 分两种情况，去较小值
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for(int i=len-1 ; i>=0 ; i--){
            for(int j=i+1; j<len ; j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                } else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        
        return dp[0][len-1];

    }
}
// @lc code=end

