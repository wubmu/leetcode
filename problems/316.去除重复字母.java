import java.util.Stack;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    /**
     1. 去重
     2. 不能打乱相对顺序   stack
     3. 字典序最小        单调栈+cnt
     */
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[256]; // 记录出现的次数
        boolean[] inStack = new boolean[256];
        for(char c : s.toCharArray()) cnt[c]++;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c]--;
            if(inStack[c]) continue;  // 已经在栈中

            while(!stack.isEmpty() && stack.peek() > c){
                if(cnt[stack.peek()] == 0) break; // 如果只剩下一个元素了不能排除
                inStack[stack.pop()] = false;
            }
            
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

