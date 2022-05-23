import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)
        return new int[0][2];

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int b[]){
                return a[0] - b[0];
            }
        });
    
        // 
        List<int[]> res = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ;){
            int right = intervals[i][1];
            int j = i + 1;
            while(j<intervals.length && intervals[j][0] <= right){
                right = Math.max(right, intervals[j][1]);
                j++;
            }
            
            res.add(new int[] {intervals[i][0],right});
            i = j;
        }
    
    // 处理最后一个

    return res.toArray(new int[res.size()][]);
    }
    
}
// @lc code=end

