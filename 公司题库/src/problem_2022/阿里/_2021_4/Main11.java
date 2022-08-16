package problem_2022.阿里._2021_4;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
class Point{
    int x;
    int y;
    int k;
    int step;

    public Point(int x, int y, int k, int step) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.step = step;
    }
}
public class Main11 {

    public static int m,n,k=5;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][][] vis;
    static char[][] grids;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = 5; // 只能使用5次飞行对称
        sc.nextLine(); // 吞掉回车

        grids = new char[n][m];
        for (int i = 0; i < n; i++) {
            grids[i] = sc.nextLine().toCharArray();
        }

        int sx=-1,sy=-1,ex=-1,ey=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grids[i][j] == 'S'){sx=i;sy=j;}
                else if (grids[i][j] =='E'){ex=i;ey=j;}
            }
        }
        int ans = bfs(grids,sx,sy,ex,ey);
        System.out.println(ans);
    }


    private static int bfs(char[][] map, int sx, int sy, int ex, int ey){
        vis = new boolean[n+1][m+1][k+1];
        Queue<Point> queue= new ArrayDeque<>();

        // 加入起点
        queue.add(new Point(sx,sy,5,0));
        vis[sx][sy][k]= true;
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()){

            Point cur = queue.poll();
            if (map[cur.x][cur.y] =='E') ans = Math.min(ans, cur.step);


//            int size = queue.size();
            for (int i = 0; i < 5; i++) {
                int nx,ny,nt;
                if (i == 4){
                    nx = n-1-cur.x;
                    ny = m-1-cur.y;
                    nt = cur.k-1;
                }else {
                    nx = cur.x + dx[i];
                    ny = cur.y + dy[i];
                    nt = cur.k;
                }

                Point next = new Point(nx,ny,nt,cur.step+1);
                if (check(next)){
                    vis[next.x][next.y][next.k]=true;
                    queue.add(next);
                }
            }

        }
        return ans == Integer.MAX_VALUE ? -1: ans;
    }

    private static boolean check(Point next) {
        int x = next.x;
        int y = next.y;
        int time =next.k;

        if(time >= 0 && x >= 0 && x < n && y >= 0 && y < m && grids[x][y] != '#' && !vis[x][y][time]){
            return true;
        }
        return false;
    }
}
