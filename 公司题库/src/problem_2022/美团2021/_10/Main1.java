package problem_2022.美团2021._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {

    public static int solution(int n, int x, int y, int[] a){

        if ((2 * x >n )&&(n > 2*y)) return -1;
        Arrays.sort(a);
//        int idx = x;
        // 淘汰人数 idx
        // 晋级人数 n-idx
        int ans = -1;
        for (int i= x; i <=y; i++){
            if ( (n-i <= y) &&(n-i)>=x && a[i-1] != a[i]) {
                ans = a[i - 1];
                break;
            }

        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x=Integer.parseInt(s[1]);
        int y=Integer.parseInt(s[2]);
        int[] arr = new int[n];
        s=br.readLine().split(" ");
        for(int i=0; i <arr.length;++i){
            arr[i]=Integer.parseInt(s[i]);
        }

        System.out.println(solution(n,x,y,arr));
    }
}
