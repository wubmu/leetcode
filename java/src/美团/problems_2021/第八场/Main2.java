package 美团.problems_2021.第八场;
import java.util.*;
import java.io.*;

/**
 * 字串双指针
 *
 * 把E看成1，F看成-1。遍历数组，遇到E就+1，遇到F就-1，如果所有的E都被F平衡完了，就从0开始重新计算，即从当前位置重新开启一段子数组计算E和F的个数差值。
 * */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int max =0;
        int cum = 0;
        for (int i = 0; i < n; i++) {
           int num = str.charAt(i)=='E'? 1: -1;
           if (cum + num >num){
               cum = cum + num;
               max = Math.max(cum, max);
           }else
               cum = num;
        }
        System.out.println(max);
    }

}
