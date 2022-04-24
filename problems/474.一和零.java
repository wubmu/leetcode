/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len= strs.length;
        int[][][] dp = new int[len + 1][ m + 1][ n+1];
        for (int i = 1; i <= len ; i++) {
            int[] var = countZerosOnes(strs[i-1]);
        }
    }
    
    private int[] countZerosOnes(String s){
        int[] cnt = new int[2];
        for (char cc:  s.toCharArray()) {
            if(cc =='0')
                cnt[0]++;
            else
                cnt[1]++;
        }
        return cnt;
    }
}
// @lc code=end

