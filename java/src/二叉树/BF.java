package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

// 宽度遍历
public class BF {

    public static void BFTraversal(Node head){
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){

            head = queue.poll();
            System.out.print(head.value + " ");

            if (head.left != null)
                queue.add(head.left);
            if (head.right != null)
                queue.add(head.right);

        }

    }

    public static int getMaxWidth(Node head){

        return 0;
    }
}
