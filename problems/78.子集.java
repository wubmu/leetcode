import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    /***
     * 位运算
     * num & 1 == 1 末尾为1
     * @param nums
     * @return
     */
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();

    //     for (int i = 0; i < (1 << nums.length); i++) {
    //         List<Integer> sub = new ArrayList<>();
    //         for (int j = 0; j < nums.length; j++) {
    //             if( ((i>>j) & 1) == 1  )
    //                 sub.add(nums[j]);
    //         }
    //         res.add(sub);
    //     }
    //     return res;
    // }


    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        dfs(0, nums);
        return res;
    }

    private  void dfs(int begin, int[] nums){
        if(begin == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        // 选
        path.add(nums[begin]);
        dfs(begin + 1, nums);

        //不选回溯
        path.remove(path.size() -1);
        dfs(begin + 1, nums);
    }
}
// @lc code=end

