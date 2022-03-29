/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {

    /**
    双指针
    时间复杂度:O(N)
    空间复杂度:O(N)
     */
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, cur=0;
        while(cur <= right){
            if(nums[cur]==2){
                //和right上的数字交换，right--, cur 不变不知道是0还是1
                int tmp = nums[cur];
                nums[cur]  = nums[right];
                nums[right] = tmp;
                right--;
            }else if(nums[cur] == 1){
                cur++;
            }else{
                // 和left的数字交换,left++, cur++ 
                int tmp = nums[cur];
                nums[cur]  = nums[left];
                nums[left] = tmp;

                cur++;
                left++;
            }
        }
    }


}
// @lc code=end

