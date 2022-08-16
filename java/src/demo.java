import java.util.Arrays;

public class demo {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2)->o1[0]==o2[0]? o2[1]-o1[1] : o1[0]-o2[0]);
        // e[0] 从小到大排序
        // e[1] 从大到小排序
        int len = envelopes.length;
        int[] arr = new int[len];
        for(int i =0 ; i < len ; i++){
            arr[i] = envelopes[i][1];
        }

        return LIS(arr);
    }

    private int LIS(int[] nums){
        //tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end= 0;
        int[] tail = new int[nums.length];
        tail[0] = nums[0];

        for(int n : nums){
            if(n > tail[end]){
                end++;
                tail[end] = n;
            }else{
                int left = 0;
                int right = end;
                while(left < right){
                    int mid  = left + (right - left) /2;
                    if(tail[mid] < n){
                        left = mid +1;
                    }else
                        right = mid;
                }

                tail[left] = n;
            }
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        return end + 1;
    }

    public static void main(String[] args) {
//        int[][] list = new int[][]{{5,4},{6,4},{6,7},{2,3}};
//        [[4,5],[4,6],[6,7],[2,3],[1,1],[1,1]]
        int[][] list = new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
        System.out.println(new demo().maxEnvelopes(list));

    }
}
