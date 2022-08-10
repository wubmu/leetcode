package demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list1 = new ArrayList<>();
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();
        list1.add(1);list2.add(1);

        Class cl1 = ArrayList.class;
        Class cl2 = CopyOnWriteArrayList.class;

        Field f1 = cl1.getDeclaredField("elementData");
        Field f2 = cl2.getDeclaredField("array");
        f1.setAccessible(true);
        f2.setAccessible(true);

        Object obj1 = f1.get(list1);
        Object obj2 = f2.get(list2);

        list1.add(2);
        list2.add(2);

        Object obj3 = f1.get(list1);
        Object obj4 = f2.get(list2);

        System.out.print(obj1==obj3 + ",");
        System.out.println(obj2==obj4);
    }
}
