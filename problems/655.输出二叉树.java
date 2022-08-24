
/*
 * @lc app=leetcode.cn id=655 lang=java
 *
 * [655] 输出二叉树
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
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        // 1. 求解树的高
        int depth =getDepth(root);
        // 求解树的宽度
        int width = 0;
        for (int i = 0; i < depth; i++) width = width*2+1;

        // 结果集
        List<List<String>> res = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                line.add("");
            }
            res.add(line);
        }

        // 前序遍历
        preOrder(root,1,0, width, res);
        return res;
    }

    private void preOrder(TreeNode root, int depth, int start, int end, List<List<String>> res) {
        if(root == null || start >end) return;
        // 获得当前节点需要插入的位置
        int insert = start+(end- start) /2;

        // 到对应层去打印
        res.get(depth-1).set(insert, root.val+"");

        //打印左右子树
        preOrder(root.left, depth+1, start, insert-1, res);
        preOrder(root.right, depth+1, insert+1, end, res);


    }

    public int getDepth(TreeNode node) {
        if(node == null)
            return 0;

        return Math.max(getDepth(node.left), getDepth(node.right))+1;
    }
}
// @lc code=end

