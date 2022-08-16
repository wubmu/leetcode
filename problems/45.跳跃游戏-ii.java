import java.util.ArrayDeque;
import java.util.Deque;

import javax.management.Query;

import sun.tools.tree.Vset;

/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    // bfs
    // public int jump(int[] nums) {
    //     int n = nums.length;
    //     if(n == 1)return 0;
    //     int ans = 0;
    //     boolean[] visit = new boolean[n];
    //     Deque<Integer> deque = new ArrayDeque<>();
        
    //     visit[0]= true;
    //     deque.addLast(0);

    //     while(!deque.isEmpty()){    
    //         int size = deque.size();
    //         ans++;
    //         for (int i = 0; i < size; i++) {
    //             int idx = deque.pollFirst();
    //             for (int j = nums[idx]; j >= 0; j--) {
    //                 //
    //                 if(j + idx >= nums.length-1)
    //                     return ans;
                    
    //                 if(!visit[idx+j]){
    //                     deque.addLast(j+idx);
    //                     visit[j+idx] = true;
    //                 }
    //             }
    //         }

    //     // ans++;
    //     }

    //     return ans;
    // }

//     public int jump(int[] nums){
//         int n = nums.length;
//         if(n == 1) return 0 ;
        
//         int end = 0;
//         int maxPosition = 0;
//         int steps= 0;
//         for (int i = 0; i < nums.length-1; i++) {
//             maxPosition = Math.max(maxPosition, i+nums[i]);
//             if (i == end){
//                 end = maxPosition;
//                 steps++;
//             }
//         }

//         return steps;

//     }
// }


public int jump(int[] nums){

    if (nums.length == 1) return 0;
    int curDistance = 0;    // 当前覆盖最远距离下标
    int ans = 0;            // 记录走的最大步数
    int nextDistance = 0;   // 下一步覆盖最远距离下标

    for (int i = 0; i < nums.length-1; i++) { // 注意这里是小于nums.size() - 1，这是关键所在
        nextDistance = nums[i] + i > nextDistance?nums[i] + i:nextDistance;
        if (i == curDistance) {
            curDistance = nextDistance;
            ans++;
        }
    }
    return ans;
}

}

// @lc code=end

