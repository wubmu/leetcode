package problem_0055_jumpGame;


/**
 * 贪心算法
 * */
public class Solution {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for(int i=0; i <= cover ; i++){
            cover = Math.max(cover, nums[i]+i);
            if (cover >= nums.length -1)
                return true;
        }

        return false;
    }
}
