/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        
    
    // 计算左右最大
        int left = Math.max(dfs(root.left) , 0);
        int right  = Math.max(dfs(root.right), 0);

        int hasNode = left + root.val + right;
        ans = Math.max(hasNode, ans);    

        return root.val + Math.max(left, right);
    }
}
// @lc code=end

