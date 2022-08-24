/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public int getNext(int n){
        int sum = 0;
        while(n > 0){
            int l = n % 10;
            sum += l*l;
            n = n /10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n , fast = n;
        do{
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        }while(slow != fast);
        return slow ==1;
    }
}
// @lc code=end

