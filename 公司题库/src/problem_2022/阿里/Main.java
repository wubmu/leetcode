package problem_2022.阿里;

import java.util.Scanner;
/*
3 3
...
.*$
.$.
WDSDA
.
*
**/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        int ans = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        int cur_x = 0,cur_y = 0;
        char[][] map = new char[n+1][m+1];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map[i] = s.toCharArray();
            for (int j = 0; j < m; j++) {
             if (map[i][j]=='*') {
                 cur_x = i;
                 cur_y = j;
             }
            }
        }

        String index = sc.next();

        for (char c: index.toCharArray()) {
            if (c == 'w' && cur_x -1 >=0){
                cur_x = cur_x -1;
            }
            if (c == 's' && cur_x+1<n)
                cur_x = cur_x+1;
            if (c == 'A' && cur_y-1 >=0)
                cur_y = cur_y -1;
            if (c == 'D' && cur_y+1<m)
                cur_y = cur_y +1;

            if (map[cur_x][cur_y] == '$'){
                ans +=1;
                map[cur_x][cur_y] ='.';
            }
        }

//        System.out.println(cur_x+"  "+cur_y);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//
//        }
        System.out.println(ans);
//        System.out.println(cur_x+"  "+cur_y);

    }
}
