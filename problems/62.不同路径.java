/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 组合数学C_{m+n-2}^{m-1}
        long ans = 1;
        for(int x = n, y =1; y<m;x++,y++){
            ans = ans * x / y;
        }
        return (int)ans;
    }

    
}
// @lc code=end

