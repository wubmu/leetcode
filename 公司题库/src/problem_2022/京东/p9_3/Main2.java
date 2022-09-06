package problem_2022.京东.p9_3;

import java.util.Scanner;

// dp[]
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            arr[i]  = sc.nextInt();
            if (arr[i] > max) max = arr[i];
        }
        
        int[] dp = new int[max+1];
        dp[2] = 1;
        for (int i = 3; i <= max ; i++) {
            int res = i;
            for (int j = 2; j <= Math.sqrt(i) ; j++) {
                if (i%j==0)
                    res = Math.min(res,dp[j]+dp[i/j]+1);
            }

            dp[i] = res;
        }

        int ans = 0;
        for (int i : arr) {
            ans += dp[i];
        }

        System.out.println(ans);
        
        
    }
}
