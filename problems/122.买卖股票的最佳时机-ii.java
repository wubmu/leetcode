/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 明天卖有利润，今天就买
        int ans = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int profit = prices[i+1] - prices[i];
            if(profit > 0)
                ans += profit;
        }
        return ans;
    }
}
// @lc code=end

