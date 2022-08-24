/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    /*
    // solution 1 动态规划
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2]; // 压缩了空间
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1]+prices[i]-fee);
            dp[1] = Math.max(dp[0]-prices[i], dp[1]);

        }
        return dp[0];

    }
*/
    public int maxProfit(int[] prices, int fee) {
        int minBase = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果是最低点则买入
            // 最高点卖出
            if(prices[i] < minBase)
                minBase = prices[i];
                  //（关键）有利润直接卖！
            else if(prices[i]-fee > minBase){
                ans += (prices[i] - fee) -minBase;
                //卖完再买入当前股票的等价股票 然后继续寻找利润！
                //等价股票相当于当前股票减去手续费
                minBase = prices[i]- fee;
            }
        }
        return ans;
    }
}
// @lc code=end

