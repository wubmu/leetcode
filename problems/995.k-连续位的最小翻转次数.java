/*
 * @lc app=leetcode.cn id=995 lang=java
 *
 * [995] K 连续位的最小翻转次数
 */

// @lc code=start
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // 记录反转次数的差值
        int[] diff = new int[nums.length+1];
        // 碰到0 反转

        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += diff[i];
            //判断是否需要反转
            if((nums[i] + cnt) %2 ==0){
                if(i+ k > nums.length)
                    return -1;
                //[i,i+k] + 1
                diff[i] +=1;
                cnt++;
                diff[i+k] -=1;
                ans++;
            }
            
        }

        return ans;

    }
}
// @lc code=end

