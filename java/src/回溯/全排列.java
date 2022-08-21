package 回溯;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static List<List<Integer>> res;
    List<List<Integer>> permute(int[] nums){

        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,track,used);
        return res;
    }

    void dfs(int[] nums, LinkedList<Integer> path, boolean[] used){
        //
        if (path.size() == nums.length){
            res.add(new LinkedList<>(path));
        }

        for(int i = 0 ; i < nums.length ; i++){
         if (used[i]){
             continue;
         }

         //进入
         path.add(nums[i]);
         used[i] = true;

         dfs(nums,path,used);

         path.removeLast();
         used[i] = false;
        }
    }
    public static void main(String[] args) {
        res = new LinkedList<>();
        int[] nums = {1, 2, 3};
        全排列 solution = new 全排列();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);



    }
}
