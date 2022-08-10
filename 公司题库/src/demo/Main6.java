package demo;

import java.util.Arrays;

public class Main6 {
    public static void main(String[] args) {
        String  str = "Aasd. Basd. Gdasd.";
        String regex ="\\.\\s*";
        System.out.println(Arrays.toString(str.split(regex)));
    }
}
