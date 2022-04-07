/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                    List<Integer> path, boolean[] used,List<List<Integer>> res){

    if(depth == len){
        res.add(new ArrayList<>(path)); //这里是重点！！！！！！
        //！！！！！！！变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表。
        return;
    }

    // 非叶子节点，选择没有访问的节点
    for(int i = 0; i < len; i++){
        if(!used[i]){
            path.add(nums[i]);
            used[i] = true;

            // 递归
            dfs(nums, len, depth + 1, path, used, res);

            //回溯

            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
    
    }
}
// @lc code=end

