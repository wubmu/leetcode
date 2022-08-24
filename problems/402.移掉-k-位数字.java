import java.util.Stack;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while(!stack.isEmpty() && c <stack.peek() && k>0){
                stack.pop();
                k--;
            }
            // 不让前面的0入栈
            if(stack.isEmpty() && c=='0') continue;
            stack.push(c);
        }

        // 如果K还没删除则从尾巴再删
        while (k-->0 && !stack.isEmpty()) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString()==""?"0" : sb.reverse().toString();

    }
}
// @lc code=end

