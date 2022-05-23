import java.util.Collections;

/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    // public int findTargetSumWays(int[] nums, int target) {
    //     int n  = nums.length;
    //     int sum = 0;
    //     for (int num : nums) {
    //         sum+=Math.abs(num);
    //     }
    //     if (Math.abs(target) > sum) return 0;
    //     int[][] dp = new int[n +1][2*sum +1];
    //     dp[0][0+sum] = 1;
    //     for (int i = 1; i <= n; i++) {
    //         int var = nums[i-1];
    //         for (int j = -sum; j <=sum; j++) {
    //             if(j+var +sum <= 2*sum )
    //                 dp[i][j +sum] += dp[i-1][j+var +sum];
    //             if(j-var+sum >= 0)
    //                 dp[i][j+sum] += dp[i-1][j-var+sum];
    //         }
            
    //     }
    // return dp[n][target + sum];
    // }

    public int findTargetSumWays(int[] nums , int target){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[i]);
        }
        if ((sum + target) % 2 == 1 ||Math.abs(target) > sum )
        return 0;

        int n = (sum + target)/2;
        
        int[] dp = new int[n+1];
        dp[0] =1;
        for (int i = 0; i < nums.length; i++) {
            int var = nums[i];
            for (int j = n; j >= var; j--) {
                dp[j] = dp[j] + dp[j-var];
            }
        }
        return dp[n];
    }

    // public int findTargetSumWays(int[] nums, int target){
    //     int sum = 0;
    //     for (int num : nums) {
    //         sum += num;
    //     }
    //     int bagSize = (target + sum) / 2;
    //     if (bagSize < 0) bagSize = -bagSize;
    //     //如果target + sum为奇数，则无解
    //     if ((target + sum) % 2 == 1) return 0;
    //     int[] dp = new int[bagSize + 1];    //dp[j] 表示：填满j这么大容积的包，有dp[j]种方法
    //     dp[0] = 1;  //装满容量为0的背包，有1种方法，就是装0件物品
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = bagSize; j >= nums[i]; j--) {
    //             dp[j] = dp[j] + dp[j - nums[i]];
    //             //   不选nums[i]    选nums[i]
    //         }
    //     }
    //     return dp[bagSize];
    // }
}
// @lc code=end

