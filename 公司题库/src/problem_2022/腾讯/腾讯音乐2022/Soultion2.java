package problem_2022.腾讯.腾讯音乐2022;

import java.util.*;

public class Soultion2 {

    public int minMax(ArrayList<Integer> a , int k, int x){

        for (int i = 0 ; i < k ; i++){
            Collections.sort(a);
            int max = a.get( a.size() -1);  //获得最大
            a.set(a.size()-1 , max-x);
        }
        Collections.sort(a);
        return a.get(a.size() -1);
    }
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.add(7);
//        list.add(2);
//        list.add(1);
//
//        Soultion2 soultion2 = new Soultion2();
//        System.out.println(soultion2.minMax(list, 3, 2));
//    }
}
