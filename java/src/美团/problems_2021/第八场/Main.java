package 美团.problems_2021.第八场;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main ma = new Main();
        String s = sc.nextLine();
        String l = sc.nextLine();
        int sum = 0;
        //转字符数组
        char[] chars = s.toCharArray();
        //求子串
        for(int i = 0; i < chars.length ; i++) {
            for(int j = i+1; j < chars.length+1 ; j++) {
                String tmp = s.substring(i,j);
                if (ma.isSubsequence(l,tmp)){
                    sum++;
                }
            }
        }
        System.out.println(sum);

    }

    public  boolean isSubsequence(String s , String t){
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;

    }
}
