package problem_2022.美团2021._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 优先都选最左
 * 男先1，后空
 * 女先空，后1
 * */
// 超时 10/12
public class Main3 {

    public static void solution(int N, char[] a, int M, char[] b){
        int ans = 0;
        int f_zero =-1, f_one = -1;
        for (int i = 0; i < N; i++) {
            if (f_zero != -1 && f_one != -1) break;
            else if (f_zero == -1 && a[i] == '0') f_zero = i;
            else if (f_one == -1 && a[i] == '1') f_one = i;
        }
        for (int i = 0; i < M; i++) {
            if (b[i] == 'M'){
                // 男先1，后空
                if ( f_one < N){
                    System.out.println(f_one+1);
                    a[f_one] = '2';
                    while (f_one < N && a[f_one]!='1') f_one++;
                }else {
                    System.out.println(f_zero+1);
                    a[f_zero] = '1';
                    if (f_zero < f_one) f_one = f_zero;
                    while (f_zero < N && a[f_zero]!='0') f_zero++;
                }
            }else {
                // 男先1，后空
                if ( f_zero < N){
                    System.out.println(f_zero+1);
                    a[f_zero] = '1';
                    if (f_zero < f_one) f_one = f_zero;
                    while (f_zero < N && a[f_zero]!='0') f_zero++;
                }else {
                    System.out.println(f_one+1);
                    a[f_one] = '2';
                    while (f_one < N && a[f_one]!='1') f_one++;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            String nums = br.readLine();
            char[] a = nums.toCharArray();
            int M = Integer.parseInt(br.readLine());

            char[] b = br.readLine().toCharArray();
            solution(N,a,M,b);
        }

    }
}
