package problem_2022.阿里._2021_4;


import java.util.Scanner;


public class Main3 {
    private static long mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // dp[i][j] 表示 i 个节点能够组成的高度不超过 j 的树的个数
        long[][] dp = new long[n+1][m+1];

        // 即不同高度的空树都只有一种可能
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=m ; j++) {
                //k为左子树节点数，总共有i个节点， 故右子树有i - 1 - k个节点， i ~[0, i - 1]
                for (int k = 0; k < i; k++) {
                    // 左右子树两两组合，左右子树高度减1
                    dp[i][j] = (dp[i][j] + dp[k][j-1]*dp[i-k-1][j-1] %mod)%mod;
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
