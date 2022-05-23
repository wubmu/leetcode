import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] idx = new int[primes.length];
        int[] dp = new int[n+1];
        Arrays.fill(idx, 1);
        for (int i = 2; i <= n; i++) {
            dp[i]= Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                dp[i] = Math.min(dp[i], dp[idx[j]]*primes[j]);
            }

            for (int j = 0; j < primes.length;j++) {
                if(dp[i] == dp[idx[j]]*primes[j])
                    idx[j]++;
            }
        }

        return dp[n];
    }
}
// @lc code=end

