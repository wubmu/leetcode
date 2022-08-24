import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map= new HashMap<>();

        int n = nums2.length;
        for (int i = n-1; i >=0; i--) {
            // 如果小于就起开
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            // next[i] = stack.isEmpty() ? -1: stack.peek();
            map.put(nums2[i], stack.isEmpty()? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = map.get(nums1[i]);
        }
    return ans;
    }
}
// @lc code=end

