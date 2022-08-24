import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0 ; i < len-1 ; i++){
            int left = nums[i+1];
            int right = len-1;
            
            // 如果和上次一样跳过
            if(i > 0 && nums[i]==nums[i-1]) continue;
            while(left < right){
                
            }


        }
        

    }
}
// @lc code=end

