/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        // 1. 去空格
        int index = 0;

        while (index < len && chars[index] == ' ') {
            index++;
        }

        if(index == len) return 0;

        // 3. 记录正负
        int sign = 1;
        char firstChar = chars[index];
        if(firstChar == '+') index++;
        else if(firstChar=='-'){
            index++;
            sign = -1;
        }

        // 将后续出现的数字字符进行转换
        int res = 0;
        while(index < len){
            char cur = chars[index];
            if(cur >'9' || cur <'0')
                break;
            
                // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
                if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && (cur-'0') > Integer.MAX_VALUE%10)){
                    return sign >0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                //合法

                res = res*10 + cur-'0';
                index++;
        }

        return sign>0 ? res: sign*res;
    }
}
// @lc code=end

