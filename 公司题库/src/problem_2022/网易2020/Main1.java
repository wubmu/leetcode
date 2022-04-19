package problem_2022.网易2020;
import java.util.*;
import java.io.*;
class Solution {
    public void myFunc(ArrayList<ArrayList<Integer>> arr) {
        // 使用自测数据按钮时调试用，正式提交时要删掉。
        System.out.println(arr);
    }
}
public class Main1 {
    static List<String> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- >0){
            String s = sc.next();
            String t = sc.next();
            f(s,t);

        }
    }

    private static void f(String s, String t) {

        String rev_s = revers01(s);
        String rev_t = revers01(t);

        String st = s.concat(t);
        String revs_t = rev_s.concat(t);
        String s_revt = s.concat(rev_t);
        String revs_revt = rev_s.concat(rev_t);

        // 在前
        String ts = t.concat(s);
        String revt_s = rev_t.concat(s);
        String t_revs = t.concat(rev_t);
        String revt_revs = rev_t.concat(rev_s);
        arr.clear();
        arr.add(t);
        arr.add(rev_t);

        // 8 个组合 s在前
        arr.add(st);
        arr.add(s_revt);
        arr.add(revs_t);
        arr.add(revs_revt);

        arr.add(ts);
        arr.add(t_revs);
        arr.add(revt_s);
        arr.add(revt_revs);


        if (arr.contains(rev_s) || arr.contains(s))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
    private static String revers01(String s){

        StringBuilder rev = new StringBuilder();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && flag == 0)
                continue;
            else if (s.charAt(i) =='0'){
                flag = 1;
                rev.append('1');
            }else if (s.charAt(i)=='1')
                rev.append('0');
        }
        return rev.toString();
    }
}
