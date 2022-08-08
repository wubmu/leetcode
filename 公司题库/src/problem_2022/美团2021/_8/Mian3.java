package problem_2022.美团2021._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

// 42-28 = 14 超时
public class Mian3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().trim().split(" ");
        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);
        int d = Integer.parseInt(nums[3]);
        int e = Integer.parseInt(nums[4]);
        int f = Integer.parseInt(nums[5]);
        int g = Integer.parseInt(nums[6]);

        PriorityQueue<int []> queue = new PriorityQueue<int[]>((t1,t2) -> t2[0]-t1[0]);
        queue.add(new int[]{e,a});
        queue.add(new int[]{f,b});
        queue.add(new int[]{g,c});
        long ans = 0;
        while (!queue.isEmpty() && d >0){
            int[] tmp = queue.poll(); // 或者价值最高的
            int num = tmp[1];
            int price = tmp[0];
            ans += (long) Math.min(num, d) * price; // 卡大数字
            d -= num;
        }
        System.out.println(ans);
    }
}
