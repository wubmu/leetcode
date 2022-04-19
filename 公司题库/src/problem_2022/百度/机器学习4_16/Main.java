package problem_2022.百度.机器学习4_16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] easy = {'e','a','s','y'};
        int ans = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == easy[idx % 4] || s.charAt(i) == (easy[idx % 4]-32) ){
                if (idx % 4 ==3)
                    ans++;
                idx++;
            }
        }
        System.out.println(ans);
    }
}
