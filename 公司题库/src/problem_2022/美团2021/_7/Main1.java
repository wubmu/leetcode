package problem_2022.美团2021._7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static boolean ischeck(String str){
        char[] s = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : s){
            if (list.contains(c))
                return false;
            else
                list.add(c);
        }

        // 条件二
        int num1 = (s[0]-'0') *10 + (s[1]-'0');
        int num2 = (s[2]-'0') *10 + (s[3]-'0');
        int num3 = (s[4]-'0') *10 + (s[5]-'0');
        if (num1 + num2 == num3)
            return true;
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int ans = 0;
        for (int i = M; i <=N ; i++) {
            if (ischeck(i+"")){
//                System.out.println(i);
                ans++;
            }

        }
        System.out.println(ans);
    }


}
