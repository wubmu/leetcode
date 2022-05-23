/*
 * @lc app=leetcode.cn id=765 lang=java
 *
 * [765] 情侣牵手
 */

// @lc code=start
class Solution {
    int[] fa= new int[70];
    
    void union(int a, int b){
        fa[find(a)] = find(b);
    }
    int find(int x){
        if (x == fa[x])
            return x;
        else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }
    /**
     * 
当有两对情侣相互坐错了位置，ta们两对之间形成了一个环。需要进行一次交换，使得每队情侣独立（相互牵手）

如果三对情侣相互坐错了位置，ta们三对之间形成了一个环，需要进行两次交换，使得每队情侣独立（相互牵手）

如果四对情侣相互坐错了位置，ta们四对之间形成了一个环，需要进行三次交换，使得每队情侣独立（相互牵手）

     */
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int pair_num = n /2;
        int cnt = 0;
        for (int i = 0; i < pair_num; i++) {
            fa[i] = i;
        }
        // 其次对于“0 4 1 2 3 5 ”可以看做0和2、0和1、1和2产生联系
        for (int i = 0; i < row.length; i+= 2) {
            int l = row[i];
            int r = row[i+1];
            
            union(l/2, r/2); // 0,1

        }

        for (int i = 0; i < pair_num; i++) {
            if(i == find(i))
                cnt++;
        }

        return pair_num - cnt;
    }
}
// @lc code=end

