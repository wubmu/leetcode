package demo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Dish{
    private final String name;
    private final int calories;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public static void main(String[] args) {
        Solution.Print();
    }
}
class Solution{
    public static void Print(){
        List<Dish> menu = Arrays.asList(new Dish("pork", 800), new Dish("beef",700),
                new Dish("chicken",400),new Dish("F F",530), new Dish("rice",350),
                new Dish("season fruit",120),new Dish("pizza",500),
                new Dish("prawns",300),new Dish("salmon",450));

        AtomicInteger count = new AtomicInteger();

        List<String> names = menu.stream().filter(d ->{count.getAndIncrement();return d.getCalories() >300;}).map(
                Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(count);
        System.out.println(names);
    }
}