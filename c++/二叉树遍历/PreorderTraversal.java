package 二叉树遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
  }
public class PreorderTraversal{
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res  = new ArrayList<>();
        prorder(root, res);
        return res;

    }

    /**
     * 方法1：递归
     * */
    private void prorder(TreeNode root, ArrayList<Integer> res) {
        if(root == null)
            return;
        res.add(root.val);
        prorder(root.left, res);
        prorder(root.right,res);
    }

    /**
     * 方法二：迭代
     * */
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode cur = st.pop();
            res.add(cur.val);
            // 把右子树放入堆（先进后出）
            if(cur.right != null)
                st.push(cur.right);
            if(cur.left != null)
                st.push(cur.left);

        }

        return res;
    }


    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null || !st.isEmpty()){

            while (root != null){
                res.add(root.val);
                st.push(root);
                root = root.left;
            }
            if (!st.isEmpty()){
                root = st.pop();
                root = root.right;
            }
        }

        return res;
    }




}
