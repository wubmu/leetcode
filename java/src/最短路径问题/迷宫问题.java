package 最短路径问题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
class Node{
    int x;
    int y;
    int step;
    Node father;

    public Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node(int x, int y, int step, Node father) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.father = father;
    }
}
public class 迷宫问题 {
    // 0 表示可以走的路，1不能走，8表示出口
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] maze;
    static int[][] dist;
//    public ArrayList<Node> winMazeGift(int[][] maze) {
//        // write code here
//        // 寻找终点
//        int row = maze.length;
//        int col = maze[0].length;
//        int ex=-1,ey=-1;
//        int[][] dis = new int[row][col];
//
//        //寻找起点和终点，初始化dis矩阵
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (maze[i][j]==8){ex=i;ey=j;}
//                dis[i][j] = Integer.MAX_VALUE;
//            }
//        }
//
//
//    }

    static void bfs(int[][]maze, int[][] dist, int sx,int sy,int ex,int ey){
        Queue<Node> queue = new ArrayDeque<>();
        dist[sx][sy] = 0; // 初始化起点
        int minStep = 0;
        queue.add(new Node(sx,sy, minStep, null));
        boolean flag = false;
        Node cur = null;
        while (!queue.isEmpty()){
            minStep++;
            int size = queue.size();
            // 把这一层搞完
            for (int j = 0; j < size; j++) {
                cur = queue.poll();
                int x = cur.x;
                int y = cur.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx == ex && ny == ey){
                        dist[ex][ey] = dist[x][y] + 1;
                        flag= true;
                        break;
                    }

                    if (isCan(nx,ny,dist,maze)){
                        // 可以加入
                        queue.add(new Node(nx,ny,minStep, cur));
                        dist[nx][ny] = dist[x][y] + 1;
                    }

                }

                if (flag)
                    break;
            }
            if (flag)
                break;

        }


        if (flag==false)
            System.out.println("没找到");
        else {
            for (int i = 0; i < maze.length; i++) {
                System.out.println(Arrays.toString(dist[i]));
            }
            while (cur != null){
                System.out.printf("x : %d  y : %d\n",cur.x,cur.y);
                cur = cur.father;
            }
            // 倒序输出
        }
    }
    public static boolean isCan(int x, int y, int[][] dis, int[][] maze){
        // dis[max]表示没访问过
        if (x < maze.length && x >=0 &&
            y < maze[0].length && y >=0 &&
            dis[x][y] ==Integer.MAX_VALUE &&
                maze[x][y] != 1
        )
            return true;
        return false;
    }
    public static void main(String[] args) {
        maze = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 8, 1},
        };

                // 寻找终点
        int row = maze.length;
        int col = maze[0].length;
        int ex=-1,ey=-1;
        int[][] dis = new int[row][col];

        //寻找起点和终点，初始化dis矩阵
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maze[i][j]==8){ex=i;ey=j;}
                dis[i][j] = Integer.MAX_VALUE;
            }
        }


        int sx = 0;
        int sy = 0;
        bfs(maze,dis,sx,sy,ex,ey);
    }
}
