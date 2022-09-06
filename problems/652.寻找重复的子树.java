import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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
import java.util.LinkedList;
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static List<TreeNode> nodes = new ArrayList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        nodes = new ArrayList<>();
        traverse(root);
        return nodes;
    }

    private static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String zz = left + "," + right + "," + root.val;


        Integer orDefault = map.getOrDefault(zz, 0);
        if (orDefault == 1) {
            nodes.add(root);
        }

        map.put(zz, orDefault + 1);
        return zz;
    }


}
// @lc code=end

