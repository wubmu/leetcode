/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfs(board, word, 0, i, j);
                if(flag) return true;
            }
        }

        return false;
    }

    boolean dfs(char[][] map , String word, int start , int x, int y ){
        if(start == word.length()-1)
            return map[x][y] == word.charAt(start);
        if( map[x][y] != word.charAt(start))
            return false;
        vis[x][y] = true;
        for (int i= 0 ; i < dx.length ; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if( check(nx, ny) &&!vis[nx][ny]){
                boolean flag = dfs(map, word, start+1, nx, ny);
                if(flag){ return true;}
            }

        }
        vis[x][y] = false;
        
        return false;

    }

    private boolean check(int x , int y ){
        return x>=0 && x < vis.length && y >=0 && y <vis[0].length;
    }
}
// @lc code=end

