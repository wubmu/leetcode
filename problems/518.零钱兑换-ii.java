import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * 1.不选择硬币i
 * f[i][j] = f[i-1][j]
 * 2.选择硬币i一次
 * f[i][j] = f[i][j-coins[i]]
 * 3.选择硬币i k次
 * f[i][j] = f[i][j - coins[i]*k]
 * 
 * 
 * 综上 f[i][j] = f[i-1][j] + f[i-1][j - coins[i]] + 
 *                f[i-1][j - 2*coins[i]]+...+
 * f[i][j-coins[i]] =  f[i-1][j-coins[i]] + f[i-1][j - 2*coins[i]]
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
  //  public int change(int amount, int[] coins) {
    //    int[][] dp = new int[coins.length +1][amount + 1];

    //     // Arrays.fill(dp[0], 0); //价值为0使，各个方案为0，除了0，0
    //     dp[0][0] = 1;
    //     for (int i = 1; i <= coins.length; i++) { //物品
    //         int val = coins[i-1];   //第i个物品的价值，从1开始
    //         for (int j = 0; j <= amount; j++) {//背包
    //             dp[i][j] = dp[i-1][j]; //不选该物品
    //             for (int k = 1; k*val <= j; k++) {
    //                 dp[i][j] += dp[i-1][j - k *val];
    //             }
    //         }
    //     }

    //     return dp[coins.length][amount];
    // }


    // public int change(int amount, int[] coins) {
    //     int[][] dp = new int[coins.length +1][amount + 1];

    //     // Arrays.fill(dp[0], 0); //价值为0使，各个方案为0，除了0，0
    //     dp[0][0] = 1;
    //     for (int i = 1; i <= coins.length; i++) { //物品
    //         int val = coins[i-1];   //第i个物品的价值，从1开始
    //         for (int j = 0; j <= amount; j++) {//背包
    //             if(j < val)
    //                 dp[i][j] = dp[i-1][j];
    //             else
    //                 dp[i][j] = dp[i-1][j] + dp[i][j-val];
    //         }
    //     }

    //     return dp[coins.length][amount];
    // }

/**
 * 
 * 空间优化
 *   dp[i][j]= dp[i−1][j] + dp[i][j−w]
​变成 dp[j] = dp[j] + dp[j-w]
 ] ,
 * @param amount
 * @param coins
 * @return
 */
        public int change(int amount, int[] coins) {    
        int[] dp = new int[amount + 1];
        dp[0] = 1; 

        // Arrays.fill(dp[0], 0); //价值为0使，各个方案为0，除了0，0
        for (int i = 1; i <= coins.length; i++) { //物品
            int val = coins[i-1];   //第i个物品的价值，从1开始
            for (int j = val; j <= amount; j++) {//背包
                dp[j] = dp[j] + dp[j-val];
            }
        }

        return dp[amount];
    }
}
// @lc code=end

