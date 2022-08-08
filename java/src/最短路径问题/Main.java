package 最短路径问题;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k  = sc.nextInt();
        double[] scores = new double[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            double score = 0;
            for (int j = 0; j < 4; j++) {
                String[] items = sc.nextLine().split(" ");
                score =  score + getScore(items);
            }
            scores[i] = score;
        }


        // 排序
        Arrays.sort(scores);
        double sum = 0;
        for (int i = n-k; i < n; i++) {
            sum = sum + scores[i];
        }
        System.out.printf("%.2f",sum);
    }

    private static double getScore(String[] items) {
        String str = items[0];
        double value = Double.parseDouble(items[1]);

        if (str.equals("attack"))
            return value*1.5;
        else if (str.equals("critical"))
            return value*2;
        else if (str.equals("critical_damage"))
            return value;
        else
            return 0;

    }
}
