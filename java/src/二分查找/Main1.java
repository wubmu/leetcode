package 二分查找;

public class Main1 {
    // 搜索左侧边界
    int left_bound(int[] nums , int target){
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right){
            int mid = left + (right-right) / 2;
            if (nums[mid] == target){
                // 收缩右边界
                right = mid;
            }else if (nums[mid] < target){
                left = mid +1;
            }else if (nums[mid] < target){
                right = mid;
            }
        }
        return left;
    }

    // 搜索右侧边界
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 当找到 target 时，收缩左侧边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }

}
