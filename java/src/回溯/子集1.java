package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集1 {
    // 元素不同
    //
    //返回去重
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> list= subSets(nums);
        for (List<Integer> s : list)
            System.out.println(s.toString());
    }

    public static List<List<Integer>> subSets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(0, nums,res,path);

        return res;
    }

    private static void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> path) {
        res.add(new ArrayList<>(path)); // 直接加有问题
        for (int i = start; i < nums.length; i++) {
            // 回溯
            path.add(nums[i]);
            backtrack(i+1, nums,res, path);
            path.remove(path.size()-1);
        }
    }
}
