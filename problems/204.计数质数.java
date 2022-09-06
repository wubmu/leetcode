import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i*i < n; i++) {
            
            // 
            if(isPrim[i]){
                for ( int j = i*i; j < n; j+= i) {
                    isPrim[j] =false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if(isPrim[i]) cnt++;
        }
    return cnt;
    }
}
// @lc code=end

