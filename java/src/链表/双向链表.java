package 链表;

import java.util.Collections;
import java.util.LinkedList;

public class 双向链表 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i : list)
            System.out.println(i);
        Collections.reverse(list);
        for(int i : list)
            System.out.println(i);
    }

}
