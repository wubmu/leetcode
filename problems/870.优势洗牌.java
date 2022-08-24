import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=870 lang=java
 *
 * [870] 优势洗牌
 */

// @lc code=start
class Solution {
    // 田忌赛马
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // num2[]的顺序不能变，用一个索引记录他的索引位置
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o2[1]-o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);

        // 比的过，就比；比不过就用最小的送人头
        int left = 0, right = n-1;
        int[] res = new int[n];
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int idx = cur[0], maxval = cur[1];
            if(maxval < nums1[right]){
                // 可以赢自己上
                res[idx] = nums1[right];
                right--;
            }else{
                //比不过拿一个最小的
                res[idx] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
// @lc code=end

