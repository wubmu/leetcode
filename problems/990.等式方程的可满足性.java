import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    int[] fa = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            fa[i] = i;
        }


    }
    
    public void union(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        if (roota == rootb)
            return;
        
        fa[rootb] = roota;
    }

    public int find(int x){
        if(fa[x] != x) fa[x] = find(fa[x])

        return fa[x];
    }
}
// @lc code=end

