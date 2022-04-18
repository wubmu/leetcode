package problem_2022.京东;


import java.util.Objects;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        String s1=in.nextLine();
        int[] n=new int[t];
        for(int i=0;i<t;i++){
            n[i]=in.nextInt();
            String s2=in.nextLine();
            String[] str=new String[n[i]];
            for(int j=0;j<n[i];j++){
                str[j]=in.nextLine();
            }
            if(!isMatch(str)){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
    public static boolean isMatch(String[] str){
        String[] stack=new String[str.length];
        int top=-1;
        for(int i=0;i<str.length;i++){
            String curr=str[i];
            if(!str[i].contains(" ")&&str[i].equals(str[i])){
                stack[++top]=str[i];
            }else {
                if(top==-1){
                    return false;
                }
                String temp=stack[top--];
                if(str[i].equals("end "+curr)&& !Objects.equals(temp, str[i])){
                    return false;
                }
            }
        }
        return top == -1;
    }
}