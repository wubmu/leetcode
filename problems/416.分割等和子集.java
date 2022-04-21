/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         sum += nums[i];
    //     }
    //     if (sum % 2 ==1) {
    //         return false;
    //     }
        
    //     //偶数开始
    //     int[][] dp = new int[nums.length +1][sum/2 +1];
    //     dp[0][0] = 0;
    //     for (int i = 1; i <= nums.length; i++) {
    //         int var = nums[i-1];
    //         for (int j = 0; j <= sum/2; j++) {
    //             if(j < var)
    //                 dp[i][j] = dp[i-1][j];
    //             else
    //                 dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-var] +var) ;
    //         }
    //     }
    // return dp[nums.length][sum/2] == sum/2;
    // }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 ==1) {
            return false;
        }
        
        //偶数开始
        int[] dp = new int[sum/2 +1];
        //dp[i][j] = max(dp[i-1][j], dp[i-1][j-var]+var)
        //dp[j] = max(dp[j] , dp[j-var]+var)
        //正序的话dp[j-var]+var 已经更新了一次不行
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            int var = nums[i-1];
            for (int j = sum/2; j >= var; j--) {
                dp[j] = Math.max(dp[j], dp[j-var] + var);
            }
        }
    return dp[sum/2] == sum/2;
    }
}
// @lc code=end

