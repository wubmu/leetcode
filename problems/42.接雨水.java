/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {

    /**
     * 以列为单位考虑左右挡板的高度
     * 时间复杂度:O(n^2)
     */
    // public int trap(int[] height) {
    //     int sum = 0;
    //     for (int i = 1; i < height.length -1; i++) {
    //         int max_left = 0;

    //         //左边最大的挡板
    //         for (int j = i-1; j >= 0; j--) {
    //             if(height[j] > max_left)
    //                 max_left = height[j];
    //         }

    //         int max_right = 0;
    //         for (int j = i+1; j < height.length; j++) {
    //             if(height[j] > max_right)
    //                 max_right = height[j];
    //         }

    //         // 只有当前位置小于两边的挡板才会注水
    //         int min = Math.min(max_left, max_right);
    //         if(height[i] < min)
    //             sum += min - height[i];
    //     }
    //     return sum;
    // }

    /**
     * 在上述解题过程中需要时刻搜索左右的最大值
     * 动态规划,记录左右的最大值
     * 时间复杂度:O(n)
     * 空间复杂度：O(n)
     */
    // public int trap(int[] height){
    //     int sum = 0;
    //     int[] max_left = new int[height.length];
    //     int[] max_right = new int[height.length];
    //     for (int i = 1; i < height.length -1; i++) {
    //         max_left[i] = Math.max(max_left[i-1], height[i-1]);
    //     }
    //     for (int i = height.length - 2; i >= 0; i--) {
    //         max_right[i] = Math.max(max_right[i+1], height[i +1]);
    //     }

    //     for (int i = 1; i < height.length -1; i++) {
    //         int min = Math.min(max_left[i], max_right[i]);
    //         if(min > height[i])
    //             sum = sum + min - height[i];
    //     }
    //     return sum;
    // }


    /**
     * 双指针
     * 时间复杂度:O（n）
     * 空间复杂度:O（1）
     */
    public int trap(int[] height){
        int sum = 0;
        int max_left = 0; //左边的最大值，它是从左往右遍历找到的
        int max_right = 0;//右边的最大值，它是从右往左遍历找到的
        int left = 0; //从左往右处理的当前下标
        int right = height.length -1;//从右往左处理的当前下标

        while(left <= right){
            if(max_left < max_right){
                sum += Math.max(0, max_left - height[left]);
                max_left = Math.max(height[left], max_left);
                left += 1;
            }else{
                sum += Math.max(0, max_right - height[right]);
                max_right = Math.max(height[right], max_right);
                right -= 1;
            }
        }
        return sum;
    }
}
// @lc code=end

