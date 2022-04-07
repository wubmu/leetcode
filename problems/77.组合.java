import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int k , n;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        // List<List<Integer>> res = new ArrayList<>();
        if(k <=0 || n<k)
            return res;
        dfs(1, new ArrayList<>());
        return res;
        
    }

    private void dfs(int begin ,List<Integer> path){
        if(path.size() == k){
            res.add(new ArrayList<>(path)); //重点
            return;
        }

        // 剪枝
        if(path.size() + (n-begin +1) < k)
            return;
            
        for(int i = begin; i<=n; i++){
            path.add(i);

            dfs(i+1, path);

            path.remove(path.size()-1);
        }

    }
}
// @lc code=end

