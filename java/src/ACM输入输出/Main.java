package ACM输入输出;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 1. 类名必须为Main
 * */
public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr;
        String input;
        while ((input=br.readLine()) != null){
            arr = input.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            System.out.println(a+b);
        }



//        //输入多组数据，每组数据占一行
        Scanner sc=  new Scanner(System.in);
//
//        while(sc.hasNext()){
//            int a =sc.nextInt();
//            int b = sc.nextInt();
//        }
//    BufferedReader br = new BufferedReader(new InputStreamReader())

        /**
         * 用例输入
         * 1
         * 2
         * a b c
         * */

//        int num1 = sc.nextInt();
//        int num2 = sc.nextInt();
//        sc.nextLine();              //容易漏掉，不加sc.nextLine()的话，a_b_c是一个Enter字符。
//        String abc = sc.nextLine();
//        System.out.println(abc);


        /**
         *
         * Sample Input
         * 4
         * 56.9 67.7 90.5 12.8
         * 5
         * 56.9 67.7 90.5 12.8
         * */
    }



}
