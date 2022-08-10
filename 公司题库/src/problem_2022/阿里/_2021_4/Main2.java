package problem_2022.阿里._2021_4;

import java.util.Scanner;

public class Main2 {
    public static long mod = 1000000007;
    //递推式 xn = Axn-1 - Bxn-2

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            int n  = sc.nextInt();
            long ans = f(a,b,n);
            System.out.println(ans);
        }
    }

    private static long f(long a, long b, int n) {
        if (n == 0)
            return 2;
        if (n == 1)
            return a;
        long[] dp = new long[3];
        dp[0] = 2;
        dp[1] = a;
        for (int i = 2; i <=n ; i++) {
            // 注意相减之后可能越界，加上个MOD防止溢出
            dp[2] = ((a*dp[1] % mod) - (b*dp[0] %mod)  +mod )%mod; // 为啥要+mod
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }


}
