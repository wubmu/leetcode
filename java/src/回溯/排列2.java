package 回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 排列（元素可重不可复选）
// input: nums = [1,2,2]
// output: [ [1,2,2],[2,1,2],[2,2,1] ]
public class 排列2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i >0  && nums[i]==nums[i-1] && !used[i-1])  continue; // 同一层 相同且用过

            track.addLast(nums[i]);
            used[i]= true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
