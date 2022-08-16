package problem_2022.美团2021._7;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String s= sc.nextLine();
        String z = sc.nextLine();
        int start = 0;
        long result =0;
        int p1 =0,p2 = 0;
        while ( p1 <s.length() && p2 < z.length()){
            if (s.charAt(p1) == z.charAt(p2)){
                result += (p1+1);
                p1++;
                p2++;
            }else
                p1++;
        }
        if (p2== m) {
            System.out.println("Yes");
            System.out.println(result);
        }else
            System.out.println("No");
    }
}
