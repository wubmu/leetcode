package 联想2022;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] cs = line.toCharArray();
        int len = cs.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp2[0] = 1;
        if (cs[0]!=cs[1])
            dp2[1] = 1;
        for (int i = 2; i < len; i++) {
            char tmp = cs[i];
            char pre = cs[i-1];
                // 不换
                if (pre == tmp) {
                    // 不换 且相等
                    dp1[i] = dp1[i-1];
                    //换 相等
                    dp2[i] = Math.min(dp1[i-1],dp2[i-1])+1;
                }
                else {
                    //不换 且不相等
                    dp1[i] = dp2[i-1];
                    //换 且不相等
                    dp2[i] = Math.min(dp1[i-1],dp2[i - 1]) +1;
                }

        }
        for (int i = 0; i < len; i++) {
            System.out.println(dp1[i]);
        }
        System.out.println("+++++++++++++++++++++++++++");
        for (int i = 0; i < len; i++) {
            System.out.println(dp2[i]);
        }
        System.out.println(Math.min(dp1[len-1], dp2[len-1]));
    }
}
