package ACM输入输出;


import org.junit.Test;

import java.util.*;

public class Map排序 {
    public static void main(String[] args) {
        // 按照key 升降排序
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        });
        map.put(2,2);
        map.put(3,3);
        map.put(1,4);


        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iter = keySet.iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
    }


    public void useCompare(){
        List<Integer> list1 = Arrays.asList(5, 3, 2, 4, 1);
        Collections.sort(list1);
        System.out.println(list1);

        List<Integer> list2 = Arrays.asList(5, 3, 2, 4, 1);
        Collections.sort(list2, (a, b) -> b - a); // 降序
        System.out.println(list2);

        // 倒置
        Collections.reverse(list2);
        System.out.println("倒置：" + list2);

        // 排序
        list2.sort(Comparator.naturalOrder());
        System.out.println("正序：" + list2);
        list2.sort(Comparator.reverseOrder());
        System.out.println("倒序：" + list2);
    }


    public void useMapCompare(){

        // 按照key 升降排序
        Map<Integer, Integer> map = new TreeMap<>((integer, t1) -> t1.compareTo(integer));
        map.put(3,2);
        map.put(2,3);
        map.put(1,4);


        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iter = keySet.iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
    }


    @Test
    public void sortByValue(){
        Map<String, String> map = new TreeMap<String, String>();
        map.put("a", "ddddd");
        map.put("c", "bbbbb");
        map.put("d", "aaaaa");
        map.put("b", "ccccc");

        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
