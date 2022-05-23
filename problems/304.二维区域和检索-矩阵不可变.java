/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 因此设定矩阵形状为 [n + 1][m + 1]（模板部分）
        sums = new int[n + 1][m +1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] +  matrix[i-1][j-1];
            }
        }
        

    }
    
    public int sumRegion(int x1, int y1, int x2, int y2) {
                // 求某一段区域和 [i, j] 的模板是 sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];（模板部分）
        // 但由于我们源数组下标从 0 开始，因此要在模板的基础上进行 + 1
        x1++; y1++; x2++; y2++;

        return sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

