import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            windows.put(c, windows.getOrDefault(c, 0)+1);
            while (windows.get(c) >1) {
                char d = s.charAt(left);
                left++;
                windows.put(d, windows.getOrDefault(d, 0)-1);
            }
            res = Math.max(res, right-left);
        }
        return res;

       
    }

}
// @lc code=end

