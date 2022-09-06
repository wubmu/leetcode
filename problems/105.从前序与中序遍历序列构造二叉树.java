/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    TreeNode build(
                    int[] preorder, int preStart, int preEnd, 
                    int[] inorder, int inStart, int inEnd){
            if (preStart > preEnd) {
                    return null;
                }
                    
            // 先获得根节点
            int rootVal = preorder[preStart];

            // 根在中序中的索引位置
            int rootIdx = valToIndex.get(rootVal);
            
            // 求左边数组长度
            int leftsize  = rootIdx - inStart;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart+1, preStart+leftsize, inorder, inStart, rootIdx-1);
            root.right = build(preorder, preStart + leftsize +1, preEnd, inorder, rootIdx+1, inEnd);
        }
}
// @lc code=end

