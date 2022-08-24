/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    /**
     * 横向查找
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0 ;
            for (j = 0; j < ans.length() && j< strs[i].length(); j++) {
                if(ans.charAt(j) !=strs[i].charAt(j))
                    break;
                
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }

        return ans;
    }
}
// @lc code=end

