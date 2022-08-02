package problem_2022.美团2021._10;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int ans = 0;
        for (int i = 1; i <= n; i++) {

            ans += Math.abs(arr[i-1] -i);
        }

        System.out.println(ans);
    }
}
