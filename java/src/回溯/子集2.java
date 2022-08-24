package 回溯;
// 子集/组合（元素可重不可复选) leetcode 90

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// input: nums = [1,2,2]
// output: [ [],[1],[2],[1,2],[2,2],[1,2,2] ]
public class 子集2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums); // 先排序， 去重要用
        backtrack(nums,0);
        return res;
    }

    public void backtrack(int[] nums, int start){
        res.add(new LinkedList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 去重 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i>start && nums[i]==nums[i-1]) continue;
            path.addLast(nums[i]);
            backtrack(nums,i+1);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2};
        子集2 s = new 子集2();
        List<List<Integer>> res = s.subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }
}
