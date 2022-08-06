package problem_2022.美团2021._9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }


//        System.out.println(base);
        Arrays.sort(a);
        int index = n - x;
        int baseline = a[index];
//        int count = x;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= 0) continue;
            else if (a[i]==baseline){
                res = n-i;
                break;
            }
        }
        System.out.println(res);

    }
}
