/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    /**
     * 区间修改：对区间内的数加N
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];
        // [i,j] diff[i]+val, diff[j+1] -val
        
        for (int[] order : bookings) {
            int i = order[0] -1;
            int j = order[1] -1;
            int val = order[2];
            diff[i] += val;
            diff[j+1] -=val;
        }
        
        // // 还原数组
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i-1];
        }

        return Arrays.copyOf(diff, n);
    }
}
// @lc code=end

