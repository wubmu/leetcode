package problem_2022.美团2021._9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String[] strArr = br.readLine().trim().split(" ");
            int[] yummy = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                yummy[i] = Integer.parseInt(strArr[i]);
                sum += yummy[i];
            }
            // 为了降低时间复杂度，可以两种情况一起求
            int max = yummy[0];
            int min = yummy[0];
            int dpMax = yummy[0];
            int dpMin = yummy[0];
            for(int i = 1; i < n; i++){
                dpMax = Math.max(dpMax + yummy[i], yummy[i]);
                max = Math.max(max, dpMax);
                dpMin = Math.min(dpMin + yummy[i], yummy[i]);
                min = Math.min(min, dpMin);
            }
            System.out.println(Math.max(sum - min, max));
        }
    }
}
