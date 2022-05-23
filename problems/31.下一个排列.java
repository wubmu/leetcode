/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /**
     * 
    先找出最大的索引 k 满足 nums[k] < nums[k+1]，如果不存在，就翻转整个数组；
    再找出另一个最大索引 l 满足 nums[l] > nums[k]；
    交换 nums[l] 和 nums[k]；
    最后翻转 nums[k+1:]。

     */
    public void nextPermutation(int[] nums) {
        // 从后往前找，找到最先出现的升序
        int n = nums.length;
        int i = n-2;

        // 找到第一个不符合降序的点
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i>= 0){
            //
            int j = n-1;
            while(j>=0 && nums[i]>= nums[j])
            j--;
        }


        
    }
}
// @lc code=end

