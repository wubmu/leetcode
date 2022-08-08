//package 最短路径问题;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class 推箱子 {
//    // 其含义是从【上】【下】【左】【右】
//    private final static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    boolean[] pos; // 人可达
//    int n , m;
//    public static int solution(char[][] grid){
//        int n = grid.length;
//        int m = grid[0].length;
//        pos = new boolean[n * m];
//        int tx=-1,ty=-1,px=-1,py=-1,bx=-1,by=-1;
//        // 找到玩家，箱子，目标的位置
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j]=='T'){ tx = i; ty = j; }
//                else if (grid[i][j]=='B'){ bx = i; by = j; }
//                else if (grid[i][j]=='S'){ px = i; py = j; }
//            }
//        }
//
//        // 计算人初始时候可达的地方
//        dfs(grid, px,py,bx,by);
//        boolean[][][] visited = new boolean[m][n][4];
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{bx,by}); // 箱子的起点
//
//
//    }
//    //使用DFS计算人可以到达的所有位置
//    public static void dfs(char[][] gird, int x , int y, int bx , int by){
//        pos[x*m +y] = true;
//        for (int i = 0; i < 4; i++) {
//            int nx = x + directions[i][0], ny = y + directions[i][1];
//            //越界
//            if (nx <0 || nx >=n || ny <0 || ny >= m) continue;
//            // 访问过，或者是墙、箱子
//            if (gird[nx][ny] == '#' || nx== bx && nx==by || pos[nx*m+ny]) continue;
//            pos[nx*m + ny] = true;
//            dfs(gird,nx,ny,bx,by);
//        }
//    }
//    public static void main(String[] args) {
//        String[] grid = {
//                "######",
//                "#T####",
//                "#..B.#",
//                "#.##.#",
//                "#...S#",
//                "######"
//        };
//        int nx  = grid.length;
//        char[][] g= new char[nx][];
//        for (int i = 0; i < nx; i++) {
//            g[i] = grid[i].toCharArray();
//        }
//
//
//
//        //输出
//        for (int i = 0; i < nx; i++) {
//            System.out.println(Arrays.toString(g[i]));
//        }
//
//
//    }
//}
//
//
//class Box {
//    int x;
//    int y;
//    int from;
//
//    public Box(int x, int y, int from) {
//        this.x = x;
//        this.y = y;
//        this.from = from;
//    }
//}
