import javax.swing.plaf.multi.MultiMenuBarUI;

/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// class Main{
//     public static void main(String[] args) {
//         S solution = new S();
//         System.out.println(solution.maxSubarraySumCircular(new int[]{5,-3,5}));
//     }
// }

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];  // 最大子数组
        int min = nums[0]; // 全局最小
        int dpmax = nums[0];
        int dpmin = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpmax = nums[i] > dpmax+nums[i]? nums[i]:dpmax+nums[i];
            max = max > dpmax ? max:dpmax;

            dpmin = nums[i] < dpmin+nums[i] ? nums[i]:dpmin+nums[i];
            min = min < dpmin? min : dpmin;
            sum += nums[i];
        }

        int ans = Math.max( (sum - min)==0?min:(sum - min), max);
        return ans;
    }
}
// @lc code=end

