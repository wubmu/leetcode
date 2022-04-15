package problem_2022.腾讯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
        int T,n;
        T = Integer.parseInt(rb.readLine());


        for (int i=0 ; i < T ; i++){
            n = Integer.parseInt(rb.readLine());
            int res = 0;
            int[] vis = new int[n+1];
            while (n>0){
                String tmp = rb.readLine();
                String[] arrs = tmp.split(" ");
                int a= Integer.parseInt(arrs[0]);
                int b= Integer.parseInt(arrs[1]);
                vis[a] = vis[a] +2;
                vis[b] = vis[b] + 2;

                res = Math.max(vis[a], res);
                res = Math.max(vis[b],res);
                n--;
            }
            System.out.println(res);

        }



    }
}
