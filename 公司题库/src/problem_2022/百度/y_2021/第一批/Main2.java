package problem_2022.百度.y_2021.第一批;

import java.util.Scanner;

public class Main2 {
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ,k;
        n =sc.nextInt();
        k = sc.nextInt();
        dfs(n, k);
        System.out.println(ans);
    }
    public static void dfs(int num , int k){
        if (num <= k || (num-k)%2==1){
            ans++;
            return;
        }else {

            dfs((num - k) / 2 + k, k);
            dfs((num - k) / 2, k);
            return;
        }
    }
}
