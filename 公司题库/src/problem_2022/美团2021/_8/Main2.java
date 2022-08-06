package problem_2022.美团2021._8;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int ans=0, dp=0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'E') {
                if (dp < 0)
                    dp = 0;

                dp++;

            }else {
                dp--;
            }

            ans = Math.max(dp,ans);
        }
        System.out.println(ans);
    }

}
