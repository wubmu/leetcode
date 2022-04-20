import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int coins_num = coins.length;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins_num; j++) {
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE/2 ? -1:dp[amount];
    }

    // public static void main(String[] args) {
    //     int[] coins = {1,2,5};
    //     int amount = 11;
    //     Solution2 solution = new Solution2();
    //     System.out.println(solution.coinChange(coins, amount));
        
    // }
}
// @lc code=end

