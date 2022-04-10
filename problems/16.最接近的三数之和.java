import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    /**
     * 排序+双指针
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length -1;
            while(start < end){
            int sum = nums[i] + nums[start] + nums[end];
            if(Math.abs(sum - target) < Math.abs(ans - target))
                ans = sum;
            if(sum > target){
                end--;
                // while(start < end && nums[end+1] == nums[end])
                //     end--;
            }
            else if(sum < target){
                start++;
                // while(start < end && nums[start-1] == nums[start])
                //     start++;
            }
            else
                return ans;
        }

        // while(i<nums.length-2 && nums[i] == nums[i+1])
        //      i++;
        }

        return ans;
    }
}
// @lc code=end

