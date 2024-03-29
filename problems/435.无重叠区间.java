import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1,o2)->o1[1]-o2[1]);

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }

        return n - ans;
    }
}
// @lc code=end

