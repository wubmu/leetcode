import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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

    // 递归
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<Integer>();
    //     dfs(res, root);
    //     return res;
    // }

    // void dfs(List<Integer> res, TreeNode root){
    //     if(root == null){
    //         return;
    //     }

    //     // 左-中-右
    //     dfs(res, root.left);
    //     res.add(root.val);
    //     dfs(res, root.right);
    // }

    /**
    辅助栈
    时间复杂度：O(n)
    空间复杂度：O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        while(stack.size()>0 || root!=null){
            while( root != null){
                stack.push(root);
                root = root.left;
            }
            // 左边走到头
            root = stack.pop();
            // 打印中序
            res.add(root.val);
            root = root.right;
        }
        
        return res;
    }


}
// @lc code=end

