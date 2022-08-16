package problem_2022.阿里._2021_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main9 {

    /*
    *
    5 2
    1 2 1 2 3
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long ans = 0;
        int left= 0,right=0;
        Map<Integer, Integer> cnt = new HashMap<>();
//        for (int left = 0, right=0; right < n; right++) {
//            int times = cnt.getOrDefault(nums[right], 0);
//            times++;
//            cnt.put(nums[right],times);
//            if (times==m){
//                // 找到了
//                ans += (n- right);
//
//                cnt.put(nums[left] , cnt.get(nums[left])-1);
//                left++;
//                right=left;
//            }
//        }

        while (left < n){

        }
        System.out.println(ans);

    }
}
