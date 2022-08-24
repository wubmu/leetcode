/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1002];
        
        for(int[] trip: trips){
            increase(arr, trip[1], trip[2], trip[0]);
        }
        int cnt = 0;
        for(int i = 0; i < 1001; i++){
            cnt = cnt+arr[i];
            if(cnt >capacity)
                return false;
        }

        return true;
    }

    private void increase(int[] arr, int i, int j, int num) {
        arr[i] = arr[i] + num;
        if (j < arr.length)
            arr[j] = arr[j] -num;
    }
}
// @lc code=end

