package problem_2022.京东;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/**
 5
 100
 0
 152
 2334
 212
 * **/
public class Main {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
//        int T = sc.nextInt();
        String[] nums = new String[T];
        for (int i = 0; i < T; i++) {
            nums[i] = br.readLine();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(searchMin(Integer.parseInt(nums[i])));
        }

    }
    private static int searchMin(int x){
        for (int i = x; i <= Integer.MAX_VALUE; i++) {
            if (jugle(i))
                return i;
        }
        return 0;
    }

    private static boolean jugle(int x){
        String s = String.valueOf(x);
        char[] nums = s.toCharArray();
        if (nums.length <= 2)
            return true;
        else {
            int cha = nums[0] - nums[1];
            for (int i = 1; i < nums.length -1; i++) {
                int tmp = nums[i] - nums[i+1];
                if (tmp != cha)
                    return false;
            }
        }
        return true;
    }

}
