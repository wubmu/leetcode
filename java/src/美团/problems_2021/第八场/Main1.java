package 美团.problems_2021.第八场;

import java.io.*;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) throws IOException {
        int n , r ,b;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr;
        String input,str;
        input = br.readLine();
        arr = input.split(" ");
        n= Integer.parseInt(arr[0]);
        r= Integer.parseInt(arr[1]);
        b= Integer.parseInt(arr[2]);

        str = br.readLine();
        if (str.length()==1)
            System.out.println(1);
        else {
            int lan = 0;
            int hong = 0;
            for (int i=0; i < str.length()-1;i++){
                if (str.charAt(i)==str.charAt(i+1) && str.charAt(i) =='r')
                    lan++;
                else if (str.charAt(i)==str.charAt(i+1) && str.charAt(i) =='b')
                    hong++;

            }
            if (r>=hong && b>= lan)
                System.out.println(str.length()+lan+hong);
            else{
                int quer = Math.max(hong- r,0);
                int queb = Math.max(lan - b,0);
                System.out.println(quer+" "+queb);
            }
        }


        }

}
