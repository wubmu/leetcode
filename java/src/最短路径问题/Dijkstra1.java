package 最短路径问题;

import java.util.Scanner;

public class Dijkstra1 {
    static int n,m;  // n是顶点，m是边
    static int g[][] = new int[10005][10005];//存放图
    static int dis[] ;//起点到每个点的最短距离
    static boolean st[];//是否被标记过
    
    static int  dijkstra(){
        dis[1] = 0;
        for (int i = 0; i < n-1; i++) {
            int t = -1;
            for (int j = 1; j <= n ; j++) {
                if (!st[j] && (t == -1 || dis[t] > dis[j]) )
                    t = j;
            }

            // 用 t 更新其他的距离
            for (int j = 1; j <= n ; j++) {
                dis[j] = Math.min(dis[j], dis[t] + g[t][j]);
            }

            st[t] =true;
        }

        if (dis[n] == Integer.MAX_VALUE)
            return -1;
        return dis[n];
    }
//3 3
//1 2 2
//2 3 1
//1 3 4

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dis = new int[n+1];
        st = new boolean[n+1];
        for (int i = 0; i <=n ; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        /**
         *
         3 3
         1 2 2
         2 3 1
         1 3 4
         * */
//        static int g[][] = new int[10005][10005];//存放图
//        static int dis[] = new int[n];//起点到每个点的最短距离
//        static boolean st[] = new boolean[10005];//是否被标记过
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            g[x][y] = d;
        }

        System.out.println(dijkstra());

    }
}
