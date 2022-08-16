package problem_2022.美团2021._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ops = br.readLine().split(" ");
        int n = Integer.parseInt(ops[0]);
        int m = Integer.parseInt(ops[1]);
        int k = Integer.parseInt(ops[2]);

        String[] tmp = br.readLine().split(" ");
        int[] arr = new int[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        System.out.println(solution(n,m,k,arr));

    }
    public static long solution(int n , int m , int k, int[] arr){
        long ans = 0;
        int left=-1, right=-1;
        while (right <n-1){
            right++;
            if (arr[right] >=k && (right-left)==m){
                ans++;
                left++;
                right=left;

            }else {
                right++;
                left=right;
            }
        }


        return  ans;
    }
}
