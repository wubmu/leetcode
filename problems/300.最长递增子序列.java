import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /***
     * 动态规划
     * dp[i] = max(dp[i], dp[i-j]) for j in (0,i)
     * 时间复杂度：O(n^2)
     * 空间复杂度:O(N)
     * @param nums
     * @return
     */
    // public int lengthOfLIS(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     int maxlen = 1;
    //     Arrays.fill(dp, 1);
    //     for (int i = 1; i < dp.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if(nums[i] > nums[j]){
    //                 dp[i] = Math.max(dp[i], dp[j]+1);
    //             }
    //         }
    //         maxlen = Math.max(dp[i], maxlen);
    //     }

    //     return maxlen;
    // }

    /**
     * 贪心+二分
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails =  new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0 , r = res;
            // 二分查找找到可插入的位置
            //[left, right)

            while(l < r){
                int mid = (l+r) >> 1;
                if(nums[mid] < num){

                    r = mid;
                }else if(nums[mid] > num)
                    l = mid +1;
            }
        }
    }
}
// @lc code=end

