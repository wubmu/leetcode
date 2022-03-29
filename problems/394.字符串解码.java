/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {

    /**
    堆栈
    时间复杂度:O(N)
    空间复杂度:O(N)
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> nums = new Stack<Integer>();
        Stack<String> strs = new Stack<String>();

        for(char c: s.toCharArray()){
            if(c == '['){
                // 数字入栈
                nums.push(multi);
                strs.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c >= '0' && c <='9'){
                multi = multi * 10 + Integer.parseInt(c+"");
            }
            else if(c == ']'){
                // res * mulit
                StringBuilder tmp = new StringBuilder();
                int cur_mulit = nums.pop();
                for(int i  = 0; i < cur_mulit ; i++) tmp.append(res);
                
                // 
                res = new StringBuilder(strs.pop() + tmp);
            }else res.append(c);
        }

    return res.toString();    
    }
}
// @lc code=end

