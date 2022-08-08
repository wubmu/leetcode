package problem_2022.美团2021._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().trim().split(" ");
        long N = Long.parseLong(nums[0]);
        long M = Long.parseLong(nums[1]);
        long Q = Long.parseLong(nums[2]);

        Map<Long, Long> pos = new HashMap<>(); // key 书的编号  value 书架位置， -1代表在小明手上
        Set<Long> lock = new HashSet<>();  // 表示加了锁的行号

        while (Q-- >0){
            String[] ops = br.readLine().split(" ");
            int op = Integer.parseInt(ops[0]);
            long x = Long.parseLong(ops[1]);
            long y = -1;
            if (ops.length == 3)
                y = Long.parseLong(ops[2]);

            if (op == 1){
                 if (pos.containsKey(x)){ // 是否记录了书本的位置
                     long p = pos.get(x);

                     // 在小团手上无效 // 原本书的位置有锁无效
                     if (p != -1L && !lock.contains(p) && !lock.contains(y))
                         pos.put(x,y);
                 }else {
                     if (!lock.contains(y))
                         pos.put(x,y);
                 }
            }

            if (op == 2){
                // 加锁
                lock.add(y);
            }
            if (op == 3){ // 解锁
                if (lock.contains(x)){
                    lock.remove(x);
                }
            }
            if (op == 4){
                if (pos.containsKey(x) && !lock.contains(pos.get(x))  && pos.get(x) != -1L) {
                    System.out.println(pos.get(x));
                    pos.put(x, -1L);
                }
                else
                    System.out.println(-1);
            }
            if (op==5){
                if (pos.containsKey(x) && pos.get(x)==-1L )
                    pos.remove(x);
            }

        }
    }
}
