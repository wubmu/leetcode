/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    // public int numberOfArithmeticSlices(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     int ans = 0;
    //     for (int i = 2; i < nums.length; i++) {
    //         if( (nums[i] - nums[i-1]) == (nums[i-1] - nums[i- 2])){
    //             dp[i] = dp[i -1] +1;
    //             ans +=   dp[i];
    //         }

    //     }
    //     return ans;
    // }

    /**
     * 长度为L的等差数列贡献为：(L-2)(L-1)/2
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] != nums[i-1] - nums[i-2])
                continue;
            //寻找等差数列的长度
            int j = i;
            int diff = nums[i]- nums[i-1];
            while(j+1< nums.length && nums[j+1]-nums[j]==diff)
            j++;
            
            // 前面还有3个
            int len = j-i+3;
            ans += (len -2)*(len-1)/2;
            i = j+1;
        }

        return ans;
    }
}
// @lc code=end

