import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
    //         public int compare(int[] pair1, int[] pair2) {
    //             return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
    //         }
    //     });
        
    //     for (int i = 0; i < k; i++) {
    //         queue.offer(new int[]{nums[i],i});
    //     }

    //     int[] ans = new int[n-k +1];
    //     ans[0] = queue.peek()[0];
    //     for (int i = k; i < n; i++) {
    //         queue.offer(new int[]{nums[i],i});
    //         // 堆头不在这个区间的删除
    //         while(queue.peek()[1] <= i-k){
    //             queue.poll();
    //         }
    //         ans[i-k+1] = queue.peek()[0];
    //     }
    // return ans;
    // }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new ArrayDeque<>(); // 双端队列 // 存在是id号
        int[] res = new int[n-k+ 1];

        for (int i = 0 , j = 0; j < res.length; i++) {

        }
    }
}
// @lc code=end

