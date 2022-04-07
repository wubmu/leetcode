package 美团.problems_2021.第八场;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.TreeMap;
import java.util.*;
import java.io.*;

/***
 * 基本思路：贪心先卖价格高的
 *
 *
 *
 * 测试用例
 * 2 3 4 5 6 7 8
 * 39
 */

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");
        long a = Integer.parseInt(params[0]);
        long b = Integer.parseInt(params[1]);
        long c = Integer.parseInt(params[2]);
        long d = Integer.parseInt(params[3]);
        long e = Integer.parseInt(params[4]);
        long f = Integer.parseInt(params[5]);
        long g = Integer.parseInt(params[6]);

        Map<Long,Long > map = new TreeMap<>((t1,t2) -> t2.compareTo(t1)); // 降序
        map.put(e,a);
        map.put(f,b);
        map.put(g,c);


        long max_profit = 0;
        for (Map.Entry<Long,Long> entry: map.entrySet()){
            long profit = entry.getKey();
            long num = entry.getValue();
            if (d > num) {
                max_profit += num * profit;
                d = d - num;
            }
            else{
                max_profit += d * profit;
                break;
            }
        }
        System.out.println(max_profit);


    }

}
