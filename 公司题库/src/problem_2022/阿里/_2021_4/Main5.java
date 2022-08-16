package problem_2022.阿里._2021_4;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] data = new int[n][2];
        int Maxmin = -1;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            data[i][0] = a;
            data[i][1] = b;
        }

        Arrays.sort(data, (o1,o2)->o1[0]-o2[0]); // 从大到小

        for (int i = n-1; i >=1 ; i--) {
            for (int j = i-1; j >=0 ; j--) {

            }
        }


    }
}
