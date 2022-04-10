import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
// class Main{
//     public static void main(final String[] args) {
//         final Solution solution = new Solution();
//         final char[][] grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
//                 { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

//         System.out.println(solution.numIslands(grid));
//     }
// }

// class Solution {
//     // 方向矩阵：向右，向下，向左，向上
//     public int[][] direct = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

//     public int numIslands(final char[][] grid) {
//         int count = 0;
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == '1') {

//                     // 遍历整个矩阵，当遇到 grid[i][j] == '1' 时，
//                     // 从此点开始做深度优先搜索 dfs，岛屿数 count + 1 且在深度优先搜索中删除此岛屿。
//                     dfs(grid, i, j);
//                     count++;
//                 }

//             }
//         }
//         return count;

//     }

//     void dfs(final char[][] grid, final int i, final int j) {
//         // 递归，结束条件
//         if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
//             return;
//         }

//         // 定义方向矩阵在上面
//         grid[i][j] = '2';
//         // 遍历四个方向，进行递归
//         for (int k = 0; k < direct.length; k++) {
//             final int next_i = i + direct[k][0];
//             final int next_j = j + direct[k][1];
//             //具体问题具体操作
//             dfs(grid, next_i, next_j);
//         }


//     }

// }

//方法二：广度优先

class Solution {
    public int[][] direct = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    public int numIslands(final char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }

    private void bfs(char[][] grid, int i , int j){
        // Queue<Integer> queue = new LinkedList<>();
        // queue.offer(i * cols + j);
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});

        while(!list.isEmpty()){
            int[] cur = list.remove();
            
            i = cur[0];
            j = cur[1];
            
            if(0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1'){
                grid[i][j] = '0';
                list.add(new int[] { i + 1, j });
                list.add(new int[] { i - 1, j });
                list.add(new int[] { i, j + 1 });
                list.add(new int[] { i, j - 1 });
            }

        }


    }



}


// @lc code=end

