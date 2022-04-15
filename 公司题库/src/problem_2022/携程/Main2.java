package problem_2022.携程;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * 5
// * 1 2 1 1 2
// * RBBBR
// *
// *
// * */
//public class Main2 {
//
//    public static void main(String[] args) {
//        // 建立两个map
//        Map<Integer,Integer> blue = new HashMap<>();
//        Map<Integer,Integer> red = new HashMap<>();
//        Scanner sc = new Scanner(System.in);
//        int  n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        String colors= sc.nextLine();
//        long ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (colors.charAt(i) == 'B')
//                if (blue.containsKey(nums[i]))
//                    blue.put(nums[i],blue.get(nums[i]) + 1);
//// /               blue.put(nums[])
//        }
//
//
//    }
//
//
//}
