import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) 
        need.put(c, need.getOrDefault(c, 0)+1);

        int left=0,right = 0;
        int len = s.length();
        int start = 0, vaild_len = Integer.MAX_VALUE;
        int valid=0;
        while (right < len) {
            // 移动
            char c = s.charAt(right);
            //窗口加大
            right++;
            // 更新哈希表:如果needs表中有当前字符，则将当前字符的数量增加
            if(need.containsKey(c)){
                windows.put(c, windows.getOrDefault(c, 0)+1);
                if (need.get(c).equals(windows.get(c))) {
                    // 如果加多了不会增加
                    valid++;
                }
            }

            // 缩小窗口
            while(valid == need.size()){
                // 更新最小的
                if(right-left<vaild_len){
                    start = left;
                    vaild_len = right-left;
                }

                //移出左边框
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(need.get(d).equals(windows.get(d)))
                        valid--;
                    windows.put(d,  windows.get(d)-1);
                }
            }
        }
        return vaild_len==Integer.MAX_VALUE?"":s.substring(start,start+vaild_len);
    }
}
// @lc code=end

